package Parent;

import org.testng.annotations.Test;

/**
 * Created by valeria on 28.10.2016.
 */
public class TestExtendExample {

    @Test
    public void tryIt() {
        Parent parent = new Parent("GHH", "01.01.01");
        Child child = new Child("GHH", "01.01.01");

        parent.makeSomeNoise();
        System.out.println("::::KKLHU");
        child.makeSomeNoise();
    }

    @Test
    public void tryParentChaid(){
        Parent child = new Child("GHH", "01.01.01");
    }
}
