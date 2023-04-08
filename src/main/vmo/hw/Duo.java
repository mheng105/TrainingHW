package src.main.vmo.hw;

public class Duo extends Boy{
    public Duo() {
        this.name="Duo";
        this.age=31;
    }

    public String getInfo() {
        return ("Name is: "+name+" Age is: "+age+" Gender is: "+sex());
    }
}
