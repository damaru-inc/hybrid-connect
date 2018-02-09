package com.solace.hybridconnect;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Status;

@Component
public class TwitterProcessor implements Processor {
	private static final Logger logger = LoggerFactory.getLogger(TwitterProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Message message = exchange.getIn();
		Object body = message.getBody();
		logger.info("Got " + body.getClass());
		String text;
		
		if (body instanceof Status) {
			Status status = (Status) body;
			text = status.getText();
			
			if (status.isRetweet()) {
				exchange.setProperty(Exchange.ROUTE_STOP, Boolean.TRUE);
				logger.info("Discarding retweet: " + text);
			}
		} else {
			text = body.toString();
		}
		
		message.setBody(text);
	}
}
