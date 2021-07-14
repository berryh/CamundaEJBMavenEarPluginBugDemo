package com.example.ejbdemo.core;

import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class SampleCoreService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public void doSomething()
	{
		LOGGER.info("I am a core service and I do things!");
	}

	@Nonnull
	public String getServiceResponse()
	{
		return "Sample Core Service gives a response.";
	}
}
