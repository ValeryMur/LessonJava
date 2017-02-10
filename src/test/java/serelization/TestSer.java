package serelization;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 * Created by Inna_Hrydiakina on 10.02.2017.
 */
public class TestSer {

    DataStorage dataStorage;
    String path = "C:\\testData\\dataStorage.ser";


    @BeforeTest
    public void loadData(){
        dataStorage = deserializeStorage(path);
    }


    @Test
    public void test1(){
      //  dataStorage = new DataStorage();
        Random random = new Random();
        System.out.println(dataStorage);
        dataStorage.testName = "name1";
        dataStorage.userName = "Jack";
        dataStorage.userAge = random.nextInt();
        dataStorage.map.put(String.valueOf(random.nextInt()), String.valueOf(random.nextInt()));
        System.out.println(dataStorage);
    }

    @AfterTest
    public void saveData(){
        serializeStorage(dataStorage, path);
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
