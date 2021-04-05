//以下代码，一步步简化

public class TestLambda {

    //3、静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("i like lambda 2");
        }
    }

    public static void main(String[] args) {
        ILike like1 = new Like();
        like1.lambda();

        ILike like2 = new TestLambda.Like2();
        like2.lambda();

        //4、局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda 3");
            }
        }

        ILike like3 = new Like3();
        like3.lambda();

        //5、匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda 4");
            }
        };
        like4.lambda();

        //6、用lambda简化
        ILike like5 = () -> {
            System.out.println("i like lambda 5");
        };
        like5.lambda();
    }
}

//1、实现一个接口
interface ILike {
    void lambda();
}
//2、实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("i like lambda 1");
    }
}