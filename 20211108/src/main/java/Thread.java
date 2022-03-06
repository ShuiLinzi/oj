class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

}

public class Thread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        java.lang.Thread thread = new java.lang.Thread(thread1);
        thread.start();

    }
}
