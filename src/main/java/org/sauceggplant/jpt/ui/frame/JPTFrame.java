package org.sauceggplant.jpt.ui.frame;


import org.sauceggplant.jpt.ui.panel.JPTPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

/**
 * Main frame.
 *
 * @author zhaozx
 */
public class JPTFrame extends AbstractComponentFrame {

    /**
     * Main panel.
     */
    private JPTPanel panel;

    /**
     * Constructor
     */
    public JPTFrame() {
        super();
    }

    public void initComponents() {
        panel = new JPTPanel();
        this.getContentPane().add(panel);
        this.addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
                    panel.getToolsPanel().getTextField().setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width - 420, 40));
                }
            }
        });
    }

    public String getLoggerClassName() {
        return JPTFrame.class.getName();
    }

    public int getComponentKey() {
        return 1;
    }

}
