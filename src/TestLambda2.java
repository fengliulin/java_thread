import java.util.concurrent.Flow;

public class TestLambda2 {



    public static void main(String[] args) {
        Ilove love = (a) -> {
            System.out.println("i love you ->" + a);
        };
        love.love(12);
    }
}

@FunctionalInterface
interface Ilove {
    void love(int a);
}

class Love implements Ilove {
    @Override
    public void love(int a) {

    }
}
