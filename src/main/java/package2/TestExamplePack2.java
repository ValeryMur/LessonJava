package package2;

import org.testng.annotations.Test;
import package1.IncapsulationExample;

/**
 * Created by valeria on 28.10.2016.
 */
public class TestExamplePack2 {
    @Test
    public void testIncepsulation(){
        IncapsulationExample incapsulationExample = new IncapsulationExample();
        incapsulationExample.age=40;
    }
}
