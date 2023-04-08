package src.main.vmo.hw;

public class Boy extends Person{
    protected String name;
    protected int age;

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String sex(){
        return "Male";
    }
}
