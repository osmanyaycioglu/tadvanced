package com.turkcell.training.concurreny.semaphore;

public class Main {

    public static void main(final String args[]) {

        PrintQueue printQueue = new PrintQueue();

        Thread thread[] = new Thread[12];
        for (int i = 0; i < 12; i++) {
            thread[i] = new Thread(new Job(printQueue),
                                   "Thread " + i);
        }

        for (int i = 0; i < 12; i++) {
            thread[i].start();
        }
    }

}
