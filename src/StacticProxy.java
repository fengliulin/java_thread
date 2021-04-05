public class StacticProxy {
    public static void main(String[] args) {

        new Thread(()  -> {
            System.out.println("我爱你");
        }).start();
        You you = new You(); // 真实对象
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("秦老师要结婚了，超级开心");
    }
}

//代理类
class WeddingCompany implements Marry {

    private Marry target; //代理的目标对象


    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry(); //代理的目标对象的方法
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}
