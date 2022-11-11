package flix.processor.ImageProcessor.Listeners;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ImageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("Consuming Message - " + new String(message.getBody()));
    }
}
