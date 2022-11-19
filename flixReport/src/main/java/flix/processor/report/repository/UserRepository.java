package flix.processor.report.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import flix.processor.report.dto.UserDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class UserRepository {
    private String URL = "http://localhost:7001/api/user/report";

    public List<UserDto> GetUsers() throws IOException, URISyntaxException, InterruptedException {
        return this.GetUsersFromApi();
    }

    private List<UserDto> GetUsersFromApi() throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var jsonList = response.body();
        UserDto[] asArray = mapper.readValue(jsonList, UserDto[].class);
        System.out.println(asArray.length);

        return List.of(asArray);
    }
}
