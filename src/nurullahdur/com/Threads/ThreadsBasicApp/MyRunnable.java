package nurullahdur.com.Threads.ThreadsBasicApp;

import static nurullahdur.com.Threads.ThreadsBasicApp.ThreadColor.ANSI_RED;

public class MyRunnable  implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run()" );
    }
}
