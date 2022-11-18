package flix.processor.user.dto;

import lombok.Getter;
import lombok.Setter;

public class ValidateUserResponseDto {

    public ValidateUserResponseDto(boolean alreadyExist) {
        AlreadyExist = alreadyExist;
    }

    public ValidateUserResponseDto() {
    }

    @Getter
    @Setter
    private boolean AlreadyExist;

}
