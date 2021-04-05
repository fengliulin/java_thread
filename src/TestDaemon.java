public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You1 you1 = new You1();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认false表示是用户线程，正常的线程都是用户线程， true开启守护线程
        thread.start();

        new Thread(you1).start();
        new Thread(new You2()).start();
    }
}

class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}


class You1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("hello world");
    }
}

class You2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365000; i++) {
            System.out.println("你");
        }
        System.out.println("hello world");
    }
}
