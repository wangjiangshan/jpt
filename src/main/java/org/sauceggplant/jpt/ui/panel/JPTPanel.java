package org.sauceggplant.jpt.ui.panel;

import java.awt.*;

import static org.sauceggplant.jpt.sys.GLOBAL.getSystemConfigByKey;

/**
 * Main panel.the panel is the content pane of JPTFrame.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public class JPTPanel extends AbstractComponentPanel {

    /**
     * Tools Panel.
     */
    private JPTToolsPanel toolsPanel;

    /**
     * View Panel.
     */
    private JPTViewPanel viewPanel;

    /**
     * Result Panel.
     */
    private JPTResultPanel resultPanel;

    /**
     * Constructor.
     */
    public JPTPanel() {
        super();
    }

    @Override
    public void initLayouts() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        viewPanel = new JPTViewPanel();
        this.add(viewPanel, BorderLayout.CENTER);
        resultPanel = new JPTResultPanel();
        resultPanel.setPreferredSize(new Dimension(Integer.parseInt(getSystemConfigByKey("DEFAULT_FRAME_WIDTH")),
                Integer.parseInt(getSystemConfigByKey("DEFAULT_RESULTPANEL_HEIGHT"))));
        this.add(resultPanel, BorderLayout.SOUTH);

        toolsPanel = new JPTToolsPanel(viewPanel, resultPanel);
//        toolsPanel.setPreferredSize(new Dimension(Integer.parseInt(getSystemConfigByKey("DEFAULT_FRAME_WIDTH")),
//                Integer.parseInt(getSystemConfigByKey("DEFAULT_TOOLPANEL_HEIGHT"))));
        this.add(toolsPanel, BorderLayout.NORTH);
    }

    @Override
    public void selfInit() {
//        this.setBackground(Color.darkGray);
    }

    @Override
    public String getLoggerClassName() {
        return JPTPanel.class.getName();
    }

    @Override
    public int getComponentKey() {
        return 2;
    }

    public JPTToolsPanel getToolsPanel() {
        return toolsPanel;
    }
}
