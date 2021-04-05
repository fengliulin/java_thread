import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {

    //模拟倒计时
    public static void tenDown() {
        int num = 10;
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(num--);
                if (num <= 0) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        //打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
