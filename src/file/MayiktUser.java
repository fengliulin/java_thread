package file;

import java.util.Objects;

public class MayiktUser {
    private String userName;
    private String age;

    public MayiktUser(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MayiktUser that = (MayiktUser) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(userName, age);

        return hash;
    }

}
