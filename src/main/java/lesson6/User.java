package lesson6;

/**
 * Created by valeria on 17.10.2016.
 */
public class User {

    public User(String name, int age){
        this.name=name;
    }
    public User(){
    }
    public User(String name, int age, String city){
        this(name, age);
        this.city=city;
    }

    public String name;
    public int age;
    public String city;
    public char gender;
    public static String type = "Human";

    public static void main(String[] args) {
    User user1 = new User("Masha", 25, "New York");
    User user2 = new User("HG", 25);
    User user3 = new User();

        user1.name = "Misha";
        user2.name = "Jaack";
        user1.age = 25;
        user2.age = 70;
        user2.city = "New York";

        System.out.println(user1.name+":"+user1.age);
        System.out.println(user2.name+":"+user2.age+":"+user2.city);
        System.out.print(User.type);
}


//    @Override
//    public String toString(){
//        return name+":"+city+":"+gender;
//    }





}
