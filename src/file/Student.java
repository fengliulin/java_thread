package file;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable, Comparable<Student> {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int n1 = this.name.hashCode();
        int n2 = this.age;
        return n1 + n2;
    }

    @Override
    public boolean equals(Object obj) {
        //判断是不是同一个对象
        if (this == obj) {
            return true;
        }

        //判断是否为空
        if (obj == null) {
            return false;
        }

        //判断obj是不是Student类
        if (obj instanceof Student) {
            Student s = (Student) obj;
            if (this.name.equals(s.getName()) && this.age == s.getAge()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 先按姓名比，然后在按年龄比
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        int n1 = this.getName().compareTo(o.getName());
        int n2 = this.age - o.getAge();
        return n1 == 0 ? n2 : n1;
    }
}
