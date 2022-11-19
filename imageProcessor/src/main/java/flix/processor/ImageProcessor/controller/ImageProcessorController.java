package flix.processor.ImageProcessor.controller;

import flix.processor.ImageProcessor.Dto.DataDto;
import flix.processor.ImageProcessor.Dto.DataReportDto;
import flix.processor.ImageProcessor.repository.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/processor")
//@SecurityScheme(
//        name = "Bearer",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer"
//
//)
public class ImageProcessorController {

    final
    DataService dataService;


    public ImageProcessorController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<DataDto> GetAll() {

        return dataService.GetAllData();
    }

    @GetMapping("/report")
    public List<DataReportDto> GetAllReport() {

        return dataService.GetReportData();
    }

}
