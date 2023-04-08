package src.main.vmo.hw;

public class Emma extends Girl{
    public Emma() {
        this.name="Emma";
        this.age=22;
    }
    public String getInfo() {
        return ("Name is: "+name+" Age is: "+age+" Gender is: "+sex());
    }
}
