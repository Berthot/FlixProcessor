package flix.processor.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public User(String name, String login, String password) {
        setName(name);
        setLogin(login);
        setPassword(password);
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
    @Column(nullable = false, unique = true)
    private String Login;

    @Getter
    @Setter
    @Column(nullable = false)
    private String Password;

}
