package flix.processor.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    public User(String name, String login, String password) {
        setName(name);
        setLogin(login);
        setPassword(password);
        setEmail(login + "@flix.com");
    }

    public User() {
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;


    @Getter
    @Setter
    @Column(nullable = false)
    private String Name;

    @Getter
    @Setter
    @Column(nullable = false)
    private String Email;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String Login;

    @Getter
    @Setter
    @Column(nullable = false)
    private String Password;

}
