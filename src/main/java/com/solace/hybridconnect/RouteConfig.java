package com.solace.hybridconnect;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteConfig extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(RouteConfig.class);

    @Autowired
    CamelContext context;

    @Override
    public void configure() throws Exception {
        logger.info("MyRoute configure");
//        from("rabbitmq://localhost/rabbitOut?queue=rabbitQueueOut&autoDelete=false")

        from("rabbitmq://localhost/rabbitOut?queue=rabbitQueueOut&autoDelete=false")
        .to("log:RABBIT-LOGGER?level=WARN")
        .to("solace-jms:topic:sol/in");

        from("solace-jms:queue:solaceOut")
        .to("log:RABBIT-LOGGER?level=WARN")
        .to("rabbitmq://localhost/rabbitIn?queue=rabbitQueueIn&autoDelete=false");

//        from("twitter://streaming/filter?keywords=#cdnpoli")
//        .process("twitterProcessor")
//        .to("log:TWITTER-LOGGER?level=WARN")
//        .to("solace-jms:topic:tweets/cdnpoli");
    }

}
