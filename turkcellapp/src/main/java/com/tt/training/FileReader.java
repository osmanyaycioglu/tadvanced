package com.tt.training;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileReader {
	@Autowired
	private RabbitTemplate rt;
	
	private ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 16);

	public void readFile(String file) {
		byte[] byteLine = new byte[1024]; 
		try (FileChannel fcChannel = FileChannel.open(Paths.get(file), StandardOpenOption.READ)) {
			List<String> lines = new ArrayList<>();
			int read = fcChannel.read(buffer);
			System.out.println("Read operation : " + read);
			buffer.flip();
			int point = 0;
			for (int i = 0; i < read; i++) {
				byte b = buffer.get();
				if (b != 10) {
					byteLine[point++] = b; 
				} else {
					String str = new String(byteLine,0,point);
					System.out.println("line : " + str);
					rt.convertAndSend("tc-topic","com.turkcell.cdr",str);
					point = 0;
				}
			}
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		FileReader fileReader = new FileReader();
		fileReader.readFile("cdr1.txt");
	}
}
