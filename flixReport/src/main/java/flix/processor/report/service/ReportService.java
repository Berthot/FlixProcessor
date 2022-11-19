package flix.processor.report.service;

import flix.processor.report.dto.DataDto;
import flix.processor.report.dto.ReportDto;
import flix.processor.report.dto.UserDto;
import flix.processor.report.repository.ProcessorRepository;
import flix.processor.report.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private static final String URL = "http://localhost:7001/api/user";

    final UserRepository userRepository;
    final ProcessorRepository processorRepository;

    public ReportService(UserRepository userRepository, ProcessorRepository processorRepository) {
        this.userRepository = userRepository;
        this.processorRepository = processorRepository;
    }

    public List<ReportDto> GetReport() throws IOException, URISyntaxException, InterruptedException {
        var users = userRepository.GetUsers();
        var datas = processorRepository.GetProcess();
        var list =  new ArrayList<ReportDto>();
        for (DataDto dta : datas                ) {
            UserDto user = users.stream().filter(x->x.getId() == dta.getUserId()).findFirst().get();
            var report = new ReportDto();
            report.setData(dta.getData());
            report.setName(user.getName());
            report.setTier(dta.getTier());
            report.setEmail(user.getEmail());
            report.setSource(dta.getSource());
            list.add(report);
        }
        return list;

    }

}
