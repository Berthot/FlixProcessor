package flix.processor.report.controller;

import flix.processor.report.dto.ReportDto;
import flix.processor.report.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/report")
//@SecurityScheme(
//        name = "Bearer",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer"
//
//)
public class ReportController {

    final
    ReportService reportService;



    public ReportController(ReportService userService) {
        this.reportService = userService;
    }

    @GetMapping
    public List<ReportDto> GetAll() throws IOException, URISyntaxException, InterruptedException {

        return reportService.GetReport();
    }

}
