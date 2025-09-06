package concurrency.cookbook.chapter01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Thread.*;

public class T01_ThreadStateBasic {
    public static void main(String[] args) {
        System.out.printf("Minimum Priority: %s\n", MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", NORM_PRIORITY);
        System.out.printf("Maximum Priority: %s\n", MAX_PRIORITY);


        Thread[] threads = new Thread[10];
        State[] status = new State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator());
            if (i % 2 == 0) {
                threads[i].setPriority(MAX_PRIORITY);
            } else {
                threads[i].setPriority(MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }
        String fileName = "D:\\ws.intellijIDE\\multithreading\\src\\main\\resources\\data\\log.txt";
        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter pw = new PrintWriter(fileWriter)) {

            for (int i = 0; i < 10; i++) {
                pw.println("Main: status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {

                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }

                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == State.TERMINATED);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void writeThreadInfo(PrintWriter pw,
                                        Thread thread,
                                        State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }

}

