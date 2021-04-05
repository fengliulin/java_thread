public class TestThread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("多线程"+i);
        }
    }

    public static void main(String[] args) {

        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程，这是代理
        Thread thread = new Thread(testThread3);
        thread.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main" + i);
        }
    }
}
