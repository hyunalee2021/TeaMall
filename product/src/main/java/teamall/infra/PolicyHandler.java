package teamall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import teamall.config.kafka.KafkaProcessor;
import teamall.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    StockRepository stockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliverCompleted'"
    )
    public void wheneverDeliverCompleted_StockDecrease(
        @Payload DeliverCompleted deliverCompleted
    ) {
        DeliverCompleted event = deliverCompleted;
        System.out.println(
            "\n\n##### listener StockDecrease : " + deliverCompleted + "\n\n"
        );

        // Sample Logic //
        Stock.stockDecrease(event);
    }
}
