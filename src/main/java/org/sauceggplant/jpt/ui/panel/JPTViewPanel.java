package org.sauceggplant.jpt.ui.panel;

import javax.swing.*;
import java.awt.*;

import static org.sauceggplant.jpt.sys.GLOBAL.getComponentTitlesByKey;

/**
 * Show Json Content on this panel.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public class JPTViewPanel extends AbstractComponentPanel {

    /**
     * Json content text pane.
     */
//    private JTextArea contentTextArea;
    private JTextPane contentTextPane;

    /**
     * Add json content text area.
     */
    private ScrollPane scrollPane;

    /**
     * Constructor.
     */
    public JPTViewPanel() {
        super();
    }

    @Override
    public void initLayouts() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        //contentTextArea = new JTextArea();
        contentTextPane = new JTextPane();
        //contentTextArea.setEditable(true);
        contentTextPane.setEditable(true);
        //contentTextArea.setForeground(Color.black);
        //contentTextArea.setBackground(
        contentTextPane.setBackground(
                new Color(Integer.parseInt("255"),
                        Integer.parseInt("255"),
                        Integer.parseInt("255"),
                        Integer.parseInt("255"))
        );
        //contentTextArea.setFont(new Font("\u5b8b\u4f53",Font.BOLD, 18));
        contentTextPane.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 18));
        scrollPane = new ScrollPane();
        //scrollPane.add(contentTextArea);
        scrollPane.add(contentTextPane);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void selfInit() {
        this.setBackground(
                new Color(Integer.parseInt("255"),
                        Integer.parseInt("255"),
                        Integer.parseInt("255"),
                        Integer.parseInt("255"))
        );
    }

    @Override
    public String getLoggerClassName() {
        return JPTViewPanel.class.getName();
    }

    @Override
    public int getComponentKey() {
        return 4;
    }

//    /**
//     * Get text area.
//     * */
//    public JTextArea getContentTextArea() {
//        return contentTextArea;
//    }

    /**
     * Get text pane.
     */
    public JTextPane getContentTextPane() {
        return contentTextPane;
    }

    public void setContentTextPane(JTextPane contentTextPane) {
        this.contentTextPane = contentTextPane;
    }
}
