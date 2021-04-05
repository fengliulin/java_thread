package syn;

import java.util.concurrent.locks.ReentrantLock;

//不安全的取钱
//两个人去银行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "招商银行");
        Drawing you = new Drawing(account, 50, "你");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");
        you.start();
        girlFriend.start();
    }
}

class Account {
    public int money; //账户里面的钱
    public String name; //账户的姓名

    private final ReentrantLock lock = new ReentrantLock();

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public  void quqian(Account account, int drawingMoney, int nowMoney) {
//        lock.lock();
        try {
            if ((account.money - drawingMoney) < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，无法取钱");
                return;
            }

            //卡内余额 = 余额-你取的钱
            account.money = account.money - drawingMoney;

            //剩余的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为：" + account.money);
            System.out.println(Thread.currentThread().getName() + "手里的钱:" + nowMoney);
        } finally {
//            lock.unlock();
        }
    }
}

class Drawing extends Thread {
    private Account account; //账户
    private int drawingMoney; //取款
    private int nowMoney; //剩余余额



    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        //锁的对象就是变化的量，需要增删改的对象锁住
//        synchronized (account) {
        account.quqian(account,drawingMoney,nowMoney);
    }

//    }
}