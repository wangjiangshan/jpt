package org.sauceggplant.jpt.log;

import org.sauceggplant.jpt.service.IERDLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract logger.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public abstract class AbstractLogger implements IERDLogger {

    /**
     * Logger.
     */
    private static Logger logger = null;

    abstract public String getLoggerClassName();

    public Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(getLoggerClassName());
            return logger;
        } else {
            return logger;
        }
    }
}
