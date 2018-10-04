package com.iopipe.logger.tinylog;

import org.pmw.tinylog.Configuration;
import org.pmw.tinylog.LogEntry;
import org.pmw.tinylog.writers.LogEntryValue;
import org.pmw.tinylog.writers.Writer;
import java.util.Set;

/**
 * This writer supports writing to IOpipe.
 *
 * @since 2018/10/04
 */
public final class IOpipeWriter
	implements Writer
{
	/**
	 * {@inheritDoc}
	 * @since 2018/10/04
	 */
	@Override
	public final void close()
	{
		// Closing is not needed
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2018/10/04
	 */
	@Override
	public final void flush()
	{
		// Flushing is not needed
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2018/10/04
	 */
	@Override
	public final Set<LogEntryValue> getRequiredLogEntryValues()
	{
		throw new Error("TODO");
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2018/10/04
	 */
	@Override
	public final void init(Configuration __conf)
		throws Exception
	{
		throw new Error("TODO");
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2018/10/04
	 */
	@Override
	public final void write(LogEntry __e)
		throws Exception
	{
		throw new Error("TODO");
	}
}

