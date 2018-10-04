package com.iopipe.logger.tinylog;

import org.iopipe.plugin.logger.LoggerUtil;
import org.pmw.tinylog.Configuration;
import org.pmw.tinylog.LogEntry;
import org.pmw.tinylog.writers.LogEntryValue;
import org.pmw.tinylog.writers.Writer;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;

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
		return new HashSet<>();
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2018/10/04
	 */
	@Override
	public final void init(Configuration __conf)
		throws Exception
	{
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2018/10/04
	 */
	@Override
	public final void write(LogEntry __e)
		throws Exception
	{
		if (__e == null)
			return;
		
		Timestamp time = __e.getTimestamp();
		
		LoggerUtil.log(
			(time == null ? System.currentTimeMillis() : time.getTime()),
			__e.getLevel(),
			__e.getClassName() + "." + __e.getMethodName(),
			__e.getMessage());
	}
}

