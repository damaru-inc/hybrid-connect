package jmsdemo;

import java.util.Collection;
import java.util.concurrent.ThreadPoolExecutor;

import javax.jms.ConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.ErrorHandlerFactory;
import org.apache.camel.Processor;
import org.apache.camel.Route;
import org.apache.camel.Service;
import org.apache.camel.VetoCamelContextStartException;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.spi.LifecycleStrategy;
import org.apache.camel.spi.RouteContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SolLifeCycleStrategyListener implements LifecycleStrategy {

	private static Logger logger = LoggerFactory
			.getLogger(SolLifeCycleStrategyListener.class);

	@Autowired
	private ConnectionFactory connectionFactory;

//	@Autowired
//	private ConnectionFactory rabbitJmsConnectionFactory;

	@Override
	public void onContextStart(CamelContext context)
			throws VetoCamelContextStartException {
		logger.info("onContextStart " + context);
		context.addComponent("solace-jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		//context.addComponent("rabbit-jms", JmsComponent.jmsComponentAutoAcknowledge(rabbitJmsConnectionFactory));

	}

	@Override
	public void onContextStop(CamelContext context) {
		logger.info("onContextStop " + context);
		// solModuleFactory.getSolJMSModule().shutdown();
	}

	@Override
	public void onComponentAdd(String name, org.apache.camel.Component component) {
		logger.info("onComponentAdd " + name);
	}

	@Override
	public void onComponentRemove(String name,
			org.apache.camel.Component component) {
		logger.info("onComponentRemove " + name);
	}

	@Override
	public void onEndpointAdd(Endpoint endpoint) {
		logger.info("onEndpointAdd " + endpoint);
	}

	@Override
	public void onEndpointRemove(Endpoint endpoint) {
		logger.info("onEndpointRemove " + endpoint);
	}

	@Override
	public void onServiceAdd(CamelContext context, Service service, Route route) {
		logger.info("onServiceAdd " + context + " " + service);
	}

	@Override
	public void onServiceRemove(CamelContext context, Service service,
			Route route) {
		logger.info("onServiceRemove " + context + " " + service);
	}

	@Override
	public void onRoutesAdd(Collection<Route> routes) {
		logger.info("onRoutesAdd " + routes);

	}

	@Override
	public void onRoutesRemove(Collection<Route> routes) {
		logger.info("onRoutesRemove " + routes);
	}

	@Override
	public void onRouteContextCreate(RouteContext routeContext) {
		logger.info("onRouteContextCreate " + routeContext);
	}

	@Override
	public void onErrorHandlerAdd(RouteContext routeContext,
			Processor errorHandler, ErrorHandlerFactory errorHandlerBuilder) {
		logger.info("onErrorHandlerAdd ");
	}

	@Override
	public void onErrorHandlerRemove(RouteContext routeContext,
			Processor errorHandler, ErrorHandlerFactory errorHandlerBuilder) {
		logger.info("onErrorHandlerAdd");
	}

	@Override
	public void onThreadPoolAdd(CamelContext camelContext,
			ThreadPoolExecutor threadPool, String id, String sourceId,
			String routeId, String threadPoolProfileId) {
		logger.info("onThreadPoolAdd " + camelContext);
	}

	@Override
	public void onThreadPoolRemove(CamelContext camelContext,
			ThreadPoolExecutor threadPool) {
		logger.info("onThreadPoolRemove " + camelContext);

	}

}
