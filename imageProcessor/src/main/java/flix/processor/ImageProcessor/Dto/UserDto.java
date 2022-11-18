package flix.processor.ImageProcessor.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {

    @Getter
    @Setter
    private Integer Id;

    @Getter
    @Setter
    private String Name;

    @Getter
    @Setter
    private String Login;

    @Getter
    @Setter
    private String Email;

    @Getter
    @Setter
    private Boolean Active;

    @Getter
    @Setter
    private String Password;
}
