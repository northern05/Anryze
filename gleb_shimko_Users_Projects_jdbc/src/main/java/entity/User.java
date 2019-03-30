package entity;

public class User {

    private final String user;
    private final String phone;
    private final String dateCreated;

    public User(String user, String phone, String dateCreated) {
        this.user = user;
        this.phone = phone;
        this.dateCreated = dateCreated;
    }
}
