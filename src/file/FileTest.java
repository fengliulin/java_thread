package file;

import java.io.*;
import java.util.*;

public class FileTest {
    /*Student s1 = new Student("张三1", 18);
            Student s2 = new Student("张三2", 19);
            Student s3 = new Student("张三3", 20);*/
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MayiktUser s1 = new MayiktUser("张三1", "21");
        MayiktUser s2 = new MayiktUser("张三1", "21");

//        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

