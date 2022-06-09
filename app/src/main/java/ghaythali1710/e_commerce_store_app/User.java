package ghaythali1710.e_commerce_store_app;

public class User {
    private String token;

    public User(){}

    public User(String token){
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
