package org.sauceggplant.jpt.ui.panel;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.sauceggplant.jpt.json.JsonFormat.formatJson;
import static org.sauceggplant.jpt.sys.GLOBAL.getComponentTitleByKey;
import static org.sauceggplant.jpt.sys.GLOBAL.getSystemConfigByKey;
import static org.sauceggplant.jpt.util.ImageUtil.getImageIconByComponentKeyAndIndex;

/**
 * Show JPT tools on this panel.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public class JPTToolsPanel extends AbstractComponentPanel {

    /**
     * Label,show json path
     */
    private JLabel label;

    /**
     * Format button.
     */
    private JButton format;

    /**
     * Test button.
     */
    private JButton test;

    /**
     * Json path content.
     */
    private JTextField textField;

    /**
     * View Panel,used to get json content.
     */
    private final JPTViewPanel viewPanel;

    /**
     * Result Panel,used to set json result.
     */
    private final JPTResultPanel resultPanel;

    /**
     * Constructor.
     */
    public JPTToolsPanel(JPTViewPanel viewPanel, JPTResultPanel resultPanel) {
        super();
        this.viewPanel = viewPanel;
        this.resultPanel = resultPanel;
    }

    @Override
    public void initLayouts() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        label = new JLabel();
        label.setText(getComponentTitleByKey(getComponentKey()));
        label.setForeground(Color.black);
        label.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 24));
        textField = new JTextField();
        textField.setForeground(Color.black);
        textField.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 18));
        textField.setPreferredSize(new Dimension(Integer.parseInt(getSystemConfigByKey("DEFAULT_FRAME_WIDTH")) - 420, 40));
        format = new JButton();
        format.setIcon(getImageIconByComponentKeyAndIndex(getComponentKey(), 0, 40, 40));
        format.setPreferredSize(new Dimension(40, 40));
        format.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //String json = viewPanel.getContentTextArea().getText();
                String json = viewPanel.getContentTextPane().getText();
                getLogger().info("####Json Format:\n" + json);
                //viewPanel.getContentTextArea().setText(formatJson(json));
                formatJson(json, viewPanel.getContentTextPane());

            }
        });

        test = new JButton();
        test.setIcon(getImageIconByComponentKeyAndIndex(getComponentKey(), 1, 40, 40));
        test.setPreferredSize(new Dimension(40, 40));
        test.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //String json = viewPanel.getContentTextArea().getText();
                    String json = viewPanel.getContentTextPane().getText();
                    getLogger().info("####Json Content:\n" + json);
                    String jsonPath = textField.getText();
                    int index = -1;
                    try {
                        index = Integer.parseInt(jsonPath.substring(jsonPath.lastIndexOf(".") + 1, jsonPath.length()));
                        jsonPath = jsonPath.substring(0,jsonPath.lastIndexOf("."));
                    } catch (Exception e2) {
                        getLogger().trace("####Last element cannot parse integer.");
                    }
                    getLogger().info("####Json Path Expression:\n" + jsonPath);
                    Object result = JsonPath.read(json, jsonPath);
                    String resultView = "";
                    if (result instanceof JSONArray) {
                        if(index==-1){
                            resultView = String.valueOf(result);
                        }else{
                            resultView = String.valueOf(((ArrayList) result).get(index));
                        }
                    } else {
                        resultView = String.valueOf(result);
                    }
                    getLogger().info("####Json Path Result:\n" + resultView);
                    resultPanel.getResultTextArea().setText(resultView);
                } catch (Exception e1) {
                    getLogger().error("####Cause:\n" + e1.getCause());
                    getLogger().error("####Error Message\n" + e1.getMessage());
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        panel.add(label);
        panel.add(textField);
        panel.add(format);
        panel.add(test);
        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void selfInit() {
//        this.setBackground(Color.gray);
    }

    @Override
    public String getLoggerClassName() {
        return JPTToolsPanel.class.getName();
    }

    @Override
    public int getComponentKey() {
        return 3;
    }

    public JTextField getTextField() {
        return textField;
    }
}
