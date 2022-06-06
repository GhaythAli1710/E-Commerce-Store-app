package ghaythali1710.e_commerce_store_app;

public class User {
    private int id;
    private String name,email,token;

    public User(){}

    public User(String token){
        this.token = token;
    }

    public User(int id, String name,String email,String token){
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getToken() {
        return this.token;
    }
}
