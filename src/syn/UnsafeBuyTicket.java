package syn;


public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station, "苦逼的我").start();
        new Thread(station, "牛逼的你们").start();
        new Thread(station, "可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable {

    private int ticketNums = 1000;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    private  void buy() {
        synchronized (BuyTicket.class) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
            System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
        }

    }
}
