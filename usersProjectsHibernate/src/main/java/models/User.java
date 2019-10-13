package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String phone;
    private String data_created;

    @OneToMany(mappedBy = "users", cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    public User(String email, String phone, String data_created){
        this.email = email;
        this.phone = phone;
        this.data_created = data_created;
        projects = new ArrayList<Project>();
    }

    public void addProject (Project project){
        projects.add(project);
    }

    public void removeProject (Project project){
        projects.remove(project);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getData_created() {
        return data_created;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setData_created(String data_created) {
        this.data_created = data_created;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", data_created='" + data_created + '\'' +
                ", projects=" + projects +
                '}';
    }
}
