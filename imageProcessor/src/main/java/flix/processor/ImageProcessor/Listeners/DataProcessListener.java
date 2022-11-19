package flix.processor.ImageProcessor.Listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import flix.processor.ImageProcessor.Dto.DataDto;
import flix.processor.ImageProcessor.repository.DataService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DataProcessListener {

    final
    DataService dataService;

    public DataProcessListener(DataService userService) {
        this.dataService = userService;
    }

    @RabbitListener(queues = {"process_image"})
    public void onMessage(Message message) throws Exception {
        var json = new String(message.getBody());

        ObjectMapper mapper = new ObjectMapper();
        DataDto data = mapper.readValue(json, DataDto.class);
        dataService.Create(data);
        System.out.println("READ->>" + data.getData());

    }

}
