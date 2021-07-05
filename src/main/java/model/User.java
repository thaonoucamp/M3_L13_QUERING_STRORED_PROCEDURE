package model;

public class User {
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_country;

    public User() {
    }

    public User(int user_id, String user_name, String user_email, String user_country) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_country = user_country;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }
}
