package com.sirsikar.competitve.general;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    public static void main(String[] args) {
       ExecutorService executor = Executors.newFixedThreadPool(10);

       for(int i = 0; i < 100; i++) {
           executor.execute(new Task(i));
       }

       executor.shutdown();
    }

    public static class Task implements Runnable {
        private int TaskId;
        public Task(int TaskId) {
            this.TaskId = TaskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + TaskId + " started by "+ Thread.currentThread().getName());
        }
    }
}
