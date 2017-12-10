package iview.wsienski.mvvmtrip.model;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class User {

    String name;
    int age;
    boolean isPremium;

    public User(String name, int age, boolean isPremium) {
        this.name = name;
        this.age = age;
        this.isPremium = isPremium;
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

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
