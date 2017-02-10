package serelization;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by valeria on 10.02.2017.
 */
public class TestSereliz {

   // DataStorage dataStorage = new DataStorage();

//    @Test
//    public void alala(){
//        dataStorage testName = "Test1";
//        dataStorage userAge=18;
//        dataStorage.map.put("MyKey","VALUE1");
//        dataStorage.map.put("MyKey2","VALUE2");
//
//        System.out.println(dataStorage);
//
//        serializeSto
//
//        public static void serializeStorage()
//    }
@Test
public void test1(){
    DataStorage dataStorage = new DataStorage();
    dataStorage.testName = "name1";
    dataStorage.userName = "Jack";
    dataStorage.userAge = 10;
    serializeStorage(dataStorage, "D:\\datastorage.ser");
}

    @Test
    public void getFromStore(){
        System.out.println(deserializeStorage("D:\\datastorage.ser"));
    }

    public static void serializeStorage(DataStorage dataStorage, String fileName){
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(fileName))){
            oss.writeObject(dataStorage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static DataStorage deserializeStorage(String filePath){
        DataStorage dataStorage = null;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
            dataStorage = (DataStorage) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataStorage;
    }
}
