package org.sauceggplant.jpt.service;

import org.slf4j.Logger;

/**
 * Logger interface.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public interface IERDLogger {

    /**
     * Get class name,used to init logger.
     *
     * @return Class name.
     */
    String getLoggerClassName();

    /**
     * Get logger.
     *
     * @return Logger.
     */
    Logger getLogger();
}
