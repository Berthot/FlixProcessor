package flix.processor.ImageProcessor.Listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import flix.processor.ImageProcessor.Dto.DataDto;
import flix.processor.ImageProcessor.repository.DataService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class DataProcessListener {

    final
    DataService dataService;

    public DataProcessListener(DataService userService) {
        this.dataService = userService;
    }

    @RabbitListener(queues = {"process_image"})
    public void onMessage(Message message) throws IOException, InterruptedException, URISyntaxException {
        var json = new String(message.getBody());

        ObjectMapper mapper = new ObjectMapper();
        DataDto data = mapper.readValue(json, DataDto.class);
        // verifica se o usuario exsite msm
        dataService.Create(data);
        System.out.println("READ->>" + data.getData());

    }

}
