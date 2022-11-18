package flix.processor.user.dto;

import flix.processor.user.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {

    public UserDto(User user) {
        setId(user.getId());
        setName(user.getName());
        setLogin(user.getLogin());
        setEmail(user.getEmail());
        setActive(!user.getName().equals(""));

    }

    public UserDto() {
    }

    @Getter
    @Setter
    private Integer Id;

    @Getter
    @Setter
    private String Name = "";

    @Getter
    @Setter
    private String Login;

    @Getter
    @Setter
    private String Email;

    @Getter
    @Setter
    private Boolean Active = false;

    @Getter
    @Setter
    private String Password;
}
