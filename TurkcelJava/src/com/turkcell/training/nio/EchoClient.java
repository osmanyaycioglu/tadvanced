package com.turkcell.training.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {
    private static SocketChannel clientSocketChannel;
    private static ByteBuffer buffer;
 
    public EchoClient() {
        try {
            clientSocketChannel = SocketChannel.open(new InetSocketAddress("localhost", 5454));
            buffer = ByteBuffer.allocate(256);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public String sendMessage(String msg) {
        buffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;
        try {
            clientSocketChannel.write(buffer);
            buffer.clear();
            clientSocketChannel.read(buffer);
            response = new String(buffer.array()).trim();
            System.out.println("response=" + response);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
     }
    
    public static void main(String[] args) {
		EchoClient client = new EchoClient();
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(1_000);
				client.sendMessage("Test Message");
			} catch (Exception e) {
			}
		}
	}
}