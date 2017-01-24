package core;

/**
 * Created by Inna_Hrydiakina on 16.09.2016.
 */
public class User {

    public User(){}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String email) {
        this("Jack", email, "qwe1rty2");
    }

    public String name;
    public String email;
    public String password;

    @Override
    public String toString() {
        return "Response [name=" + name + ",email=" + email + ", password=" + password + "]";
    }

}
