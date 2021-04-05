import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {

    private String url; //网络图片地址
    private String name;//保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader1 webDownloader1 = new WebDownloader1();
        webDownloader1.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) {
        TestCallable t1 = new TestCallable("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "1.jpg");
        TestCallable t2 = new TestCallable("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "2.jpg");
        TestCallable t3 = new TestCallable("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        try {
            Boolean rs1 = r1.get();
            Boolean rs2 = r2.get();
            Boolean rs3 = r3.get();
            System.out.println(rs1);
            System.out.println(rs2);
            System.out.println(rs3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //关闭服务
        ser.shutdownNow();
    }
}

class WebDownloader1 {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}

