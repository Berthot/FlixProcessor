package flix.processor.ImageProcessor.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import flix.processor.ImageProcessor.Dto.DataDto;
import flix.processor.ImageProcessor.Dto.UserDto;
import flix.processor.ImageProcessor.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class DataService {
    @Autowired
    DataRepository dataRepository;

    public void Create(DataDto data) throws IOException, InterruptedException, URISyntaxException {
        var dd = new Data(data);
        ValidateUser();
//        dataRepository.save(dd);
    }

    private void ValidateUser() throws IOException, InterruptedException, URISyntaxException {
        String uri = "http://localhost:7001/api/user/1";
        ObjectMapper mapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        UserDto user = mapper.readValue(response.body(), UserDto.class);

        System.out.println(user.getEmail());

    }
}
