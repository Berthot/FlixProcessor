package flix.processor.ImageProcessor.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import flix.processor.ImageProcessor.Dto.*;
import flix.processor.ImageProcessor.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Service
public class DataService {
    public static final String URL = "http://localhost:7001/api/user";
    @Autowired
    DataRepository dataRepository;

    public void Create(DataDto data) throws Exception {
        var dd = new Data(data);
        var validated = ValidateUserPOST(data.getUserId());
        if (!validated)
            throw new Exception("throw custom exception: user not valid");

        dataRepository.save(dd);
    }

    private void ValidateUserGet(int userId) throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL + "/" + userId))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        UserDto user = mapper.readValue(response.body(), UserDto.class);

        System.out.println(user.getEmail());

    }

    private boolean ValidateUserPOST(int userId) throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        var stringUrl = "http://localhost:7001/api/user/validate";
        var obj = new ValidateUserRequestDto(userId, "token");
        System.out.println(mapper.writeValueAsString(obj));
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(stringUrl))
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(obj)))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ValidateUserResponseDto user = mapper.readValue(response.body(), ValidateUserResponseDto.class);

        return user.isAlreadyExist();

    }

    public List<DataDto> GetAllData() {
        List<Data> data = dataRepository.findAll();
        List<DataDto> dataDtos = new ArrayList<DataDto>();

        for (Data i : data) {
            dataDtos.add(new DataDto(i));
        }
        return dataDtos;
    }

    public List<DataReportDto> GetReportData() {
        List<Data> data = dataRepository.findAll();
        List<DataReportDto> dataDtos = new ArrayList<DataReportDto>();

        for (Data i : data) {
            dataDtos.add(new DataReportDto(i));
        }
        return dataDtos;
    }
}
