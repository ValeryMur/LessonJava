package Parent;

/**
 * Created by valeria on 28.10.2016.
 */
public class Parent {

    public Parent (String name, String birthData){
        this.name=name;
        this.birthData=birthData;
    }

    public String name = "Dowakin";
    public String birthData = "10.02.1950";


    public void makeSomeNoise(){
        System.out.println("LA-LA-LA");
    }

    public void sleep() throws  InterruptedException {
        Thread.sleep(5000);
    }
}
