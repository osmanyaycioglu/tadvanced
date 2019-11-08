package com.turkcell.training.concurreny.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

    private List<String> buffer;

    private final Exchanger<List<String>> exchanger;

    public Consumer(final List<String> buffer,
                    final Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;

        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Cycle %d\n",
                              cycle);

            try {
                this.buffer = this.exchanger.exchange(this.buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Consumer: %d\n",
                              this.buffer.size());

            for (int j = 0; j < 10; j++) {
                String message = this.buffer.get(0);
                System.out.printf("Consumer: %s\n",
                                  message);
                this.buffer.remove(0);
            }
            cycle++;
        }
    }
}
