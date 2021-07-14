package com.example.ejbdemo.core.event;

import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

import com.example.ejbdemo.core.SampleCoreService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Stateless
public class SampleCamundaEvent extends BaseCamundaEvent
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@EJB
	private SampleCoreService sampleCoreService;

	@Override
	void executeCamundaEvent(@Nonnull final DelegateExecution eventContext) throws JsonProcessingException
	{
		LOGGER.info("This is a sample event!");
		sampleCoreService.doSomething();
	}
}
