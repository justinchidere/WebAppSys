package edu.fra.uas.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.fra.uas.BeanExampleApplication;

@Component
public class MessageService {
    private String message;
    private int counter = 0;
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    public String getMessage() {
        log.debug("Getting message: {}", message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        log.debug("Setting message to: {}", message);
    }

    public int increment() {
        counter++;
        return counter;
    }
}
