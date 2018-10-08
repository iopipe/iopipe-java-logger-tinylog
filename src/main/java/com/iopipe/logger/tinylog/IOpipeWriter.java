package com.iopipe.logger.tinylog;

import com.iopipe.plugin.logger.LoggerUtil;
import org.pmw.tinylog.Configuration;
import org.pmw.tinylog.LogEntry;
import org.pmw.tinylog.writers.LogEntryValue;
import org.pmw.tinylog.writers.PropertiesSupport;
import org.pmw.tinylog.writers.Writer;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * This writer supports writing to IOpipe.
 *
 * @since 2018/10/04
 */
@PropertiesSupport(name="iopipe", properties={})
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
		return EnumSet.<LogEntryValue>of(LogEntryValue.CLASS,
			LogEntryValue.DATE,
			LogEntryValue.LEVEL,
			LogEntryValue.MESSAGE,
			LogEntryValue.METHOD,
			LogEntryValue.PRECISE_DATE,
			LogEntryValue.RENDERED_LOG_ENTRY);
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
		
		String m = __e.getMessage();
		if (m == null)
			m = __e.getRenderedLogEntry​();
		
		Date time = __e.getDate();
		LoggerUtil.log(
			(time == null ? System.currentTimeMillis() : time.getTime()),
			__e.getLevel(),
			__e.getClassName() + "." + __e.getMethodName(),
			m);
	}
}

