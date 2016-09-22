package org.sauceggplant.jpt;

import org.sauceggplant.jpt.log.AbstractLogger;
import org.sauceggplant.jpt.ui.frame.JPTFrame;

/**
 * Main entry.
 *
 * @author zhaozx
 */
public class App extends AbstractLogger {

    /**
     * Main entry.
     *
     * @param args params.
     */
    public static void main(String[] args) {
        new JPTFrame();
    }

    @Override
    public String getLoggerClassName() {
        return App.class.getName();
    }
}
