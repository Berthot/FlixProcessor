package flix.processor.report.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import flix.processor.report.dto.DataDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ProcessorRepository {

    private String URL = "http://localhost:8001/api/processor";


    public List<DataDto> GetProcess() throws IOException, URISyntaxException, InterruptedException {
        return GetDataFromApi();
    }


    private List<DataDto> GetDataFromApi() throws IOException, InterruptedException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .GET()
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var jsonList = response.body();
        DataDto[] asArray = mapper.readValue(jsonList, DataDto[].class);
        System.out.println(asArray.length);

        return List.of(asArray);
    }
}
