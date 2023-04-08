package src.main.vmo.hw;

public class Anna extends Girl{
    public Anna() {
        this.name="Anna";
        this.age=20;
    }
    public String getInfo() {
        return ("Name is: "+name+" Age is: "+age+" Gender is: "+sex());
    }
}
