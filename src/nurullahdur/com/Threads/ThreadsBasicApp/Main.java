package nurullahdur.com.Threads.ThreadsBasicApp;

import static nurullahdur.com.Threads.ThreadsBasicApp.ThreadColor.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(ANSI_RESET + "Main'den Merhabalar");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName(" == Another Thread == ");
        anotherThread.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_PURPLE + "Hello From Bilinmez(Anonymous) Sınıftan");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED +  "Hello from the anonymous class's implementation of runs()") ;
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated, so I'm running again");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
                }
            }
        });

        myRunnableThread.start();
        System.out.println("Main Thread'ten Tekrardan Merhabalar");


    }
}
