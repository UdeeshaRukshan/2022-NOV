package PastPapers.Question3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Object lock=new Object();

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Pattern 1 =");
        String pattern02= sc.next();

        System.out.print("Enter Pattern 2 =");
        String pattern01= sc.next();

        System.out.print("Enter count =");
        int count= sc.nextInt();

        System.out.println("=======Threads start printing patterns.=======");

        Pattern01 pattern1 = new Pattern01(lock, pattern01, count);
        Thread thread1 = new Thread(pattern1, "Thread 1");

        Pattern02 pattern2= new Pattern02(lock, pattern02,count);
        Thread thread2 = new Thread(pattern2, "Thread 2");

        try {
            thread1.start();
            thread2.start();



            thread1.join();
            thread2.join();

        } catch (Exception e) {

        }

    }
}
