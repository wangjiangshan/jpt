package org.sauceggplant.jpt.ui.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Show JPT result on this panel.
 */
public class JPTResultPanel extends AbstractComponentPanel {

    /**
     * Result Text Area. show result.
     */
    private JTextArea resultTextArea;

    /**
     * Add result text area.
     */
    private ScrollPane scrollPane;

    @Override
    public void initLayouts() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setForeground(Color.black);
//        resultTextArea.setBackground(Color.gray);
        resultTextArea.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 18));
        scrollPane = new ScrollPane();
        scrollPane.add(resultTextArea);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void selfInit() {
//        this.setBackground(Color.gray);
    }

    @Override
    public String getLoggerClassName() {
        return JPTResultPanel.class.getName();
    }

    @Override
    public int getComponentKey() {
        return 5;
    }

    public JTextArea getResultTextArea() {
        return resultTextArea;
    }
}
