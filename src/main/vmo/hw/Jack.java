package src.main.vmo.hw;

public class Jack extends Boy{
    public Jack() {
        this.name="Jack";
        this.age=19;
    }

    public String getInfo() {
        return ("Name is: "+name+" Age is: "+age+" Gender is: "+sex());
    }
}
