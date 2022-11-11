package flix.processor.user.util.excecao;

import lombok.Getter;
import lombok.Setter;

public class InvalidEntity extends Exception {

    public InvalidEntity(String code, String mess) {
        super(mess);
        this.code = code;
        this.message = mess;
    }

    @Getter @Setter
    private String message;
    @Getter @Setter
    private String code;
}
