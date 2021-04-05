import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread {

    private String url; //网络图片地址
    private String name;//保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "1.jpg");
        TestThread2 t2 = new TestThread2("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "2.jpg");
        TestThread2 t3 = new TestThread2("https://commons.apache.org/proper/commons-io/images/commons-logo.png", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
