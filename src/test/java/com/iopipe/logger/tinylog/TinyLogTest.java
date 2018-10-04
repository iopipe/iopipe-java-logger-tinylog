package com.iopipe.logger.tinylog;

import org.junit.jupiter.api.Test;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for tinylog.
 *
 * @since 2018/10/04
 */
public class TinyLogTest
{
	/**
	 * Tests the logging.
	 *
	 * @since 2018/10/04
	 */
	@Test
	public void test()
	{
		// Activate writer
		Configurator.currentConfig().writer(new IOpipeWriter()).activate();
		
		Logger.debug("Debug message!");
		Logger.info("Info message!");
		Logger.trace("Trace message!");
		Logger.warn("Warning message!");
		Logger.error(new Throwable("Oops!"), "Oopsie!");
	}
}

