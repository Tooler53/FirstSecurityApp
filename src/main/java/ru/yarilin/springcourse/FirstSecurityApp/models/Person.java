package ru.yarilin.springcourse.FirstSecurityApp.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов")
    @Column
    private String username;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    @Column
    private int birthday;

    @Column
    private String password;

    public Person() {
    }

    public Person(String username, int birthday) {
        this.username = username;
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
               "username='" + username + '\'' +
               ", birthday=" + birthday +
               ", password='" + password + '\'' +
               '}';
    }
}
