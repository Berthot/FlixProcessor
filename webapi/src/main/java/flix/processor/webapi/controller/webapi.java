package flix.processor.webapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import flix.processor.webapi.Dto.DataDto;
import flix.processor.webapi.Service.WebApiService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webapi")
//@SecurityScheme(
//        name = "Bearer",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer"
//)
public class webapi {

    final
    WebApiService service;

    public webapi(WebApiService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> Process(@RequestBody String dta) throws JsonProcessingException {
        service.SendToQueue(dta);
        return new ResponseEntity<>(200, HttpStatus.CREATED);

    }

}
