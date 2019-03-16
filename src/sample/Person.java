package sample;

public class Person
{
    String fname;
    String sname;
    int age;
    int points;

    public Person(String fname, String sname, int age, int points) {
        this.fname = fname;
        this.sname = sname;
        this.age = age;
        this.points = points;
    }

    public Person() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", points=" + points +
                '}';
    }
}
