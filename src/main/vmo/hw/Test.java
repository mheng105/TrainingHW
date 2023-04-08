package src.main.vmo.hw;

public class Test {
    public static void main(String[] args) {
        Test test=new Test();
        System.out.println("PERSONAL INFORMATION");
        test.annaInfo();
        test.emmaInfo();
        test.duoInfo();
        test.jackInfo();

    }

    public void annaInfo(){
        Anna anna=new Anna();
        System.out.println(anna.getInfo());
    }

    public void emmaInfo(){
        Emma emma=new Emma();
        System.out.println(emma.getInfo());
    }

    public void jackInfo(){
        Jack jack=new Jack();
        System.out.println(jack.getInfo());
    }

    public void duoInfo(){
        Duo duo=new Duo();
        System.out.println(duo.getInfo());
    }
}
