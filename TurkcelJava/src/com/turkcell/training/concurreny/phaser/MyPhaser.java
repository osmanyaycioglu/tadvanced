package com.turkcell.training.concurreny.phaser;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(final int phase,
                                final int registeredParties) {
        switch (phase) {
            case 0:
                return this.studentsArrived();
            case 1:
                return this.finishFirstExercise();
            case 2:
                return this.finishSecondExercise();
            case 3:
                return this.finishExam();
            default:
                return true;
        }
    }

    private boolean studentsArrived() {
        System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
        System.out.printf("Phaser: We have %d students.\n",
                          this.getRegisteredParties());
        return false;
    }

    private boolean finishFirstExercise() {
        System.out.printf("Phaser: All the students has finished the first exercise.\n");
        System.out.printf("Phaser: It's turn for the second one.\n");
        return false;
    }

    private boolean finishSecondExercise() {
        System.out.printf("Phaser: All the students has finished the second exercise.\n");
        System.out.printf("Phaser: It's turn for the third one.\n");
        return false;
    }

    private boolean finishExam() {
        System.out.printf("Phaser: All the students has finished the exam.\n");
        System.out.printf("Phaser: Thank you for your time.\n");
        return true;
    }
}

