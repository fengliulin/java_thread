package file;

import java.util.Objects;

public class Student1 implements Comparable<Student1> {
    private String name;
    private int stuNo;

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", stuNo=" + stuNo +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public Student1(String name, int stuNo) {
        this.name = name;
        this.stuNo = stuNo;
    }

    public Student1() {
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student1 = (Student1) o;

        return this.name == student1.name && this.stuNo == student1.stuNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stuNo);
    }*/

    @Override
    public int compareTo(Student1 o) {
//        int n1 = this.name.compareTo(o.getName());
        int n2 = this.stuNo - o.stuNo;
        return n2;
    }
}
