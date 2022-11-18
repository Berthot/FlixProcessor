package flix.processor.user.dto;

import lombok.Getter;
import lombok.Setter;

public class ValidateUserRequestDto {

    @Getter
    @Setter
    private int UserId;

    @Getter
    @Setter
    private String Token;
}
