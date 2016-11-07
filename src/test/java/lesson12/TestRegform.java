package lesson12;

import org.testng.annotations.Test;

/**
 * Created by valeria on 07.11.2016.
 */
public class TestRegform {

    @Test
    public void regUser(){
//        Iregform regForm = new Iregform() {
//            public void typeName(String name) {
//
//            }
//
//            public void typeEmail(String email) {
//
//            }
//
//            public void typePassword(String pass) {
//
//            }
//
//            public void clickSubmit() {
//
//            }
//        };
        Iregform regForm = new RegForm1();
        regForm.typeEmail("Jack@fg.kj");
        regForm.typeName("Jack");
        regForm.typePassword("5676798798");
        regForm.clickSubmit();


    }
}
