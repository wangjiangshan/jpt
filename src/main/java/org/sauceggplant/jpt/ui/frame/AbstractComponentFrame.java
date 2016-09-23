package org.sauceggplant.jpt.ui.frame;

import org.sauceggplant.jpt.service.IERDComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

//import static com.sun.awt.AWTUtilities.setWindowOpacity;
import static org.sauceggplant.jpt.sys.GLOBAL.*;

/**
 * Abstract component frame.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public abstract class AbstractComponentFrame extends JFrame implements IERDComponent {

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
    public AbstractComponentFrame() {
        initComponents();
        this.setTitle(getComponentTitleByKey(getComponentKey()));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
//        setWindowOpacity(this, 0.8f);
        this.setSize(new Dimension(Integer.parseInt(getSystemConfigByKey("DEFAULT_FRAME_WIDTH")),
                Integer.parseInt(getSystemConfigByKey("DEFAULT_FRAME_HEIGHT"))));
        this.setVisible(true);
        getLogger().debug("####" + getComponentName() + ":" + ID);
        getLogger().info("####" + getComponentCode() + " has been initialized.");
    }

    abstract public void initComponents();

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
