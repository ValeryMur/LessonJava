package Parent;

/**
 * Created by valeria on 28.10.2016.
 */
public class Child extends Parent {

    public Child (String name, String birthData){
        super(name, birthData);
    }

    public void cry() {
        makeSomeNoise();
        name = "Sparrow";
    }

    @Override  //переписываем метод родителя - переопределение, но есть перегрузка..прост к перенту методов добавляем еше данные
    public void makeSomeNoise(){
        super.makeSomeNoise();  //super jghtltktybz rkfccf hjlbntkz bp rkfcf dsit
        System.out.println("hfv urhfue hfeuei");
    }


}
