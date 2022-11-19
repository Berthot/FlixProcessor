package flix.processor.ImageProcessor.Dto;

import lombok.Getter;
import lombok.Setter;

public class ValidateUserRequestDto {

    public ValidateUserRequestDto(int userId, String token) {
        UserId = userId;
        Token = token;
    }

    public ValidateUserRequestDto() {
    }

    @Getter
    @Setter
    private int UserId;

    @Getter
    @Setter
    private String Token;
}
