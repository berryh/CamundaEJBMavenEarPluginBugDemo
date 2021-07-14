package com.example.ejbdemo.core.event;

import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class BaseCamundaEvent implements JavaDelegate
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public void execute(@Nonnull final DelegateExecution execution) throws Exception
	{
		try
		{
			executeCamundaEvent(execution);
		}
		catch (Exception e)
		{
			// Simple example exception handling
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
	}

	abstract void executeCamundaEvent(@Nonnull final DelegateExecution eventContext) throws JsonProcessingException;
}
