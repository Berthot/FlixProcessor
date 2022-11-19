package flix.processor.user.dto;

import lombok.Getter;
import lombok.Setter;

public class UserReportDto {

    public UserReportDto(Integer id, String name, String email) {
        Id = id;
        Name = name;
        Email = email;
    }

    public UserReportDto(){

    }

    @Getter
    @Setter
    private Integer Id;

    @Getter
    @Setter
    private String Name = "";

    @Getter
    @Setter
    private String Email;

}
