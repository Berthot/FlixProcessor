package flix.processor.ImageProcessor.Dto;

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
