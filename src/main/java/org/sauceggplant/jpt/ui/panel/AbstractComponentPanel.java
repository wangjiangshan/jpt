package org.sauceggplant.jpt.ui.panel;

import org.sauceggplant.jpt.service.IERDComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

import java.util.UUID;

import static org.sauceggplant.jpt.sys.GLOBAL.getComponentCodeByKey;
import static org.sauceggplant.jpt.sys.GLOBAL.getComponentNameByKey;

/**
 * Abstract component panel.all of the child class must by implements initLayouts,initComponents,selfInit,
 * getLoggerClassName,getComponentKey methods.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public abstract class AbstractComponentPanel extends JPanel implements IERDComponent {

    /**
     * Component id.
     */
    private String ID = UUID.randomUUID().toString();

    /**
     * Logger.
     */
    private Logger logger = null;

    /**
     * Default constructor.
     */
    public AbstractComponentPanel() {
        initLayouts();
        initComponents();
        selfInit();
        this.setVisible(true);
        getLogger().debug("####" + getComponentName() + ":" + ID);
        getLogger().info("####" + getComponentCode() + " has been initialized.");
    }

    abstract public void initLayouts();

    abstract public void initComponents();

    abstract public void selfInit();

    abstract public String getLoggerClassName();

    abstract public int getComponentKey();

    public String getComponentName() {
        return getComponentNameByKey(getComponentKey());
    }

    public String getComponentCode() {
        return getComponentCodeByKey(getComponentKey());
    }

    public String getComponentId() {
        return ID;
    }

    public Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(getLoggerClassName());
            return logger;
        } else {
            return logger;
        }
    }
}
