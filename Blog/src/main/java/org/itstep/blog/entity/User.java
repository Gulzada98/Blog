package org.itstep.blog.entity;

public class User {

    private Long id;
    private String email;
    private String fullName;
    private String password;
    private String photo;

    public User(Long id, String email, String fullName, String password, String photo) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.photo = photo;
    }

    public User(Long id, String email, String fullName, String password) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
