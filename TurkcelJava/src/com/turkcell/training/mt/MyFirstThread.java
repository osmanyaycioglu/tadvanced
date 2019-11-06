package com.turkcell.training.mt;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyFirstThread extends Thread {

	public static AtomicLong counter = new AtomicLong();
	public static AtomicBoolean ba = new AtomicBoolean();
	public static ReentrantLock lock = new ReentrantLock();
	public static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
	
	public long lcounter = 0;
	public static long counterS = 0;

	boolean cont = true;
	
	public static synchronized void increase() {
		counterS++;
	}
	
	public static void increaseLock() {
		try {
			lock.tryLock(100, TimeUnit.MILLISECONDS);
			counterS++;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

	public static void increaseRWLock() {
		try {
			rwlock.readLock().lock();
			rwlock.writeLock().lock();

			counterS++;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

	public MyFirstThread() {
		setName("MyTread");
	}

	@Override
	public void run() {
		long localCounter = 0;
		long delta = System.currentTimeMillis();
		while (cont) {

			try {
				// Thread.sleep(1000);
				// System.out.println(LocalTime.now() + " hello " + cont);
				counter.incrementAndGet();
				// lcounter++;
				// increase();
				localCounter++;
				if (localCounter == 1_000_000) {
					System.out.println("Delta : " + (System.currentTimeMillis() - delta));
					return;
				}
			} catch (Exception e) {
				cont = false;
				e.printStackTrace();
				System.out.println(cont);
			}
		}
	}
}
