package nurullahdur.com.Threads.BankApp;

public class Main {

    public static void main(String[] args) {
        final BankAccount bankAccount = new BankAccount("123",100.00);

        Thread trThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(300.00);
                bankAccount.withdraw(50.00);
            }
        });
        Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(203.00);
                bankAccount.withdraw(32.21);
            }
        });

        trThread1.start();
        trThread2.start();

    }

}
