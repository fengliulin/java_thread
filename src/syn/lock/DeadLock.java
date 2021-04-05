package syn.lock;

//死锁，多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");

        g1.start();
        g2.start();
    }
}

//口红
class Lipstick {

}

//镜子
class Mirror {
}

class Makeup extends Thread {

    //需要的共享资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick(); //一个口红
    static Mirror mirror = new Mirror(); //一个镜子

    int choice;//选择
    String girlName; //使用化妆品的人

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        makeup();
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() {
        if (choice == 0) {
            synchronized (lipstick) { //获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (mirror) { //一秒后获得镜子
                    System.out.println(this.girlName + "获得镜子的锁");
                }
            }
        } else {
            synchronized (mirror) { //获得镜子的锁
                System.out.println(this.girlName+"获得镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lipstick) { //一秒后获得口红
                    System.out.println(this.girlName + "获得口红的锁");
                }
            }
        }
    }
}
