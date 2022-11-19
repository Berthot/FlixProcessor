package flix.processor.report.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {


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
    private String Email = "";
}
