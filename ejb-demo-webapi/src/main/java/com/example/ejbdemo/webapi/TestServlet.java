package com.example.ejbdemo.webapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ejbdemo.core.SampleCoreService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class TestServlet extends HttpServlet
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@EJB
	private SampleCoreService sampleCoreService;

	@Override
	protected void doGet(@Nonnull final HttpServletRequest req, @Nonnull final HttpServletResponse resp)
	{
		try (PrintWriter out = resp.getWriter())
		{
			final String serviceResponse = sampleCoreService.getServiceResponse();
			out.write(serviceResponse);
		}
		catch (IOException e)
		{
			LOGGER.error("Something went wrong while building the monitor page", e);
		}
	}
}
