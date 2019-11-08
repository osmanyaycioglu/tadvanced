package com.turkcell.training.concurreny.semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private final Semaphore semaphore;
    private final boolean   freePrinters[];
    private final Lock      lockPrinters;

    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");

    public PrintQueue() {
        this.semaphore = new Semaphore(3);
        this.freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            this.freePrinters[i] = true;
        }
        this.lockPrinters = new ReentrantLock();
    }

    public void printJob(final Object document) {
        String name = Thread.currentThread()
                            .getName();
        try {
            this.semaphore.acquire();

            System.out.println(name + " 获得信号量  at : " + this.sdf.format(new Date()));

            int assignedPrinter = this.getPrinter();

            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",
                              name,
                              assignedPrinter,
                              duration);
            TimeUnit.SECONDS.sleep(duration);

            //
            this.freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + "   at : " + this.sdf.format(new Date()) + "\r\n");

            this.semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;

        try {
            this.lockPrinters.lock();

            for (int i = 0; i < this.freePrinters.length; i++) {
                if (this.freePrinters[i]) {
                    ret = i;
                    this.freePrinters[i] = false;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.lockPrinters.unlock();
        }

        return ret;
    }
}
