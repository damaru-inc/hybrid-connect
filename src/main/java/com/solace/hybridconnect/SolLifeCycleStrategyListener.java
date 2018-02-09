package com.solace.hybridconnect;

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

	@Override
	public void onContextStart(CamelContext context)
			throws VetoCamelContextStartException {
		logger.info("onContextStart, adding solace-jms to the context " + context);
		context.addComponent("solace-jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
	}

	@Override
	public void onContextStop(CamelContext context) {
		logger.debug("onContextStop " + context);
		// solModuleFactory.getSolJMSModule().shutdown();
	}

	@Override
	public void onComponentAdd(String name, org.apache.camel.Component component) {
		logger.debug("onComponentAdd " + name);
	}

	@Override
	public void onComponentRemove(String name,
			org.apache.camel.Component component) {
		logger.debug("onComponentRemove " + name);
	}

	@Override
	public void onEndpointAdd(Endpoint endpoint) {
		logger.debug("onEndpointAdd " + endpoint);
	}

	@Override
	public void onEndpointRemove(Endpoint endpoint) {
		logger.debug("onEndpointRemove " + endpoint);
	}

	@Override
	public void onServiceAdd(CamelContext context, Service service, Route route) {
		logger.debug("onServiceAdd " + context + " " + service);
	}

	@Override
	public void onServiceRemove(CamelContext context, Service service,
			Route route) {
		logger.debug("onServiceRemove " + context + " " + service);
	}

	@Override
	public void onRoutesAdd(Collection<Route> routes) {
		logger.debug("onRoutesAdd " + routes);

	}

	@Override
	public void onRoutesRemove(Collection<Route> routes) {
		logger.debug("onRoutesRemove " + routes);
	}

	@Override
	public void onRouteContextCreate(RouteContext routeContext) {
		logger.debug("onRouteContextCreate " + routeContext);
	}

	@Override
	public void onErrorHandlerAdd(RouteContext routeContext,
			Processor errorHandler, ErrorHandlerFactory errorHandlerBuilder) {
		logger.debug("onErrorHandlerAdd ");
	}

	@Override
	public void onErrorHandlerRemove(RouteContext routeContext,
			Processor errorHandler, ErrorHandlerFactory errorHandlerBuilder) {
		logger.debug("onErrorHandlerAdd");
	}

	@Override
	public void onThreadPoolAdd(CamelContext camelContext,
			ThreadPoolExecutor threadPool, String id, String sourceId,
			String routeId, String threadPoolProfileId) {
		logger.debug("onThreadPoolAdd " + camelContext);
	}

	@Override
	public void onThreadPoolRemove(CamelContext camelContext,
			ThreadPoolExecutor threadPool) {
		logger.debug("onThreadPoolRemove " + camelContext);

	}

}
