package flix.processor.report.util.excecao;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FormatarExcecao {

    @ExceptionHandler({GenericException.class, RuntimeException.class})
    public ResponseEntity<Object> sqlError(GenericException ex) {
        String retorno = "{" +
                "\"codigo\":\""+ex.getCode()+"\"," +
                "\"mensagem\":\""+ex.getMessage()+"\"" +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<Object>(retorno, headers, HttpStatus.BAD_REQUEST);
    }
}



