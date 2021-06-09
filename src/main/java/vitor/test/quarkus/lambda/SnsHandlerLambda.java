package vitor.test.quarkus.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.jboss.logging.Logger;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named("snsHandler")
public class SnsHandlerLambda implements RequestHandler<SNSEvent, String> {

    private static final Logger LOG = Logger.getLogger(SnsHandlerLambda.class);

    static Map<Class<?>, ObjectReader> READERS = new HashMap<>();

    private ObjectMapper mapper = new ObjectMapper();

    static {
        READERS.put(BookCreateDTO.class, new ObjectMapper().readerFor(BookCreateDTO.class));
    }
    @Override
    public String handleRequest(SNSEvent input, Context context) {

        for(SNSEvent.SNSRecord record: input.getRecords()){
            if(record.getSNS().getType().equals("Notification")){

                try{
                    BookCreateDTO message = readObject(BookCreateDTO.class, record.getSNS().getMessage());
                    LOG.info("[BOOK-SNS] SNS MESSAGE OK: " + message.getLibraryCode());
                } catch (Exception e) {
                    LOG.error("[BOOK-SNS] SNS ERROR: " + e.getMessage(), e);
                }

            }else{
                LOG.info("[BOOK-SNS] SNS MESSAGE IGNORED: " + record.getSNS().getType());
            }
        }

        return "OK";
    }

    private <T> T readObject(Class<T> clazz, String message) {
        T object = null;
        try {
            object = READERS.get(clazz).readValue(message);
        } catch (JsonProcessingException e) {
            LOG.errorv("Unable to deserialize message <{0}> to Class <{1}>", message, clazz.getSimpleName());
            throw new RuntimeException(e);
        }
        return object;
    }
}
