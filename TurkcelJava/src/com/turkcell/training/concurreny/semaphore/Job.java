package com.turkcell.training.concurreny.semaphore;

public class Job implements Runnable {

    private final PrintQueue printQueue;

    public Job(final PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        //System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        this.printQueue.printJob(new Object());
        //System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
