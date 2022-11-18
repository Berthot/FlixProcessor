package flix.processor.webapi.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import flix.processor.webapi.Dto.DataDto;
import flix.processor.webapi.producer.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebApiService {
    @Autowired
    private QueueSender queueSender;

    public void SendToQueue(String dataDto) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
        queueSender.Send(dataDto);
//        queueSender.Send(mapper.writeValueAsString(dataDto));
    }
}
