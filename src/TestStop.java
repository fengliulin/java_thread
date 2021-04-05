public class TestStop implements Runnable {

    //1、这只一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run.." + i++);
        }
    }

    //设置一个公开方法停止线程，转换标识位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 100000; i++) {
            System.out.println("1");
            if (i == 90000) {
                testStop.stop();
                break;
            }
        }
    }
}
