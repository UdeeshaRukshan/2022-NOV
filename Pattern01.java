package PastPapers.Question3;

import java.util.concurrent.BlockingDeque;



public class Pattern01 implements Runnable{
    private Object lock;
    private String pattern;
    private int count;

    public Pattern01() {
    }
    public Pattern01(Object lock, String pattern, int count) {
        this.lock = lock;
        this.pattern = pattern;
        this.count = count;
    }

    public void run(){

        synchronized (lock){

            for (int i=0; i<count; i++)
            {
                System.out.print("Pattern 02 Thread = ");
                // inner loop to handle number spaces
                // values changing acc. to requirement
                for (int j=count-i; j>1; j--)
                {
                    // printing spaces
                    System.out.print(" ");
                }

                //  inner loop to handle number of columns
                //  values changing acc. to outer loop
                for (int j=0; j<=i; j++ )
                {
                    // printing stars
                    System.out.print(pattern+" ");
                }

                // ending line after each row
                System.out.println();
                try {
                    lock.notify();
                    Thread.sleep(100);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
