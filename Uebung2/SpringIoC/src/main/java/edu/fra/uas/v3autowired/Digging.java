package edu.fra.uas.v3autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pleaseDig")
public class Digging implements Work {
    private static final Logger LOGGER = LoggerFactory.getLogger(Digging.class);

    @Override
    public void doWork() {
        LOGGER.info(" --> digging a hole 2 meters deep");
    }

}
