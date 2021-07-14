package com.example.ejbdemo.webapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	protected void doGet(@Nonnull final HttpServletRequest req, @Nonnull final HttpServletResponse resp)
	{
		try (PrintWriter out = resp.getWriter())
		{
			out.write("Demo Version 1.0.0");
		}
		catch (IOException e)
		{
			LOGGER.error("Something went wrong while building the monitor page", e);
		}
	}
}