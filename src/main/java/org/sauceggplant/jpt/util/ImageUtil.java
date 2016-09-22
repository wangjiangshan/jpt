package org.sauceggplant.jpt.util;

import org.sauceggplant.jpt.log.AbstractLogger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import static org.sauceggplant.jpt.sys.GLOBAL.*;

/**
 * Image files read.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public final class ImageUtil extends AbstractLogger {

    /**
     * Set component's image.
     *
     * @param component    Who need set image.
     * @param g            Graphics.
     * @param componentKey The component key
     */
    public static void setImageIcon(JComponent component, Graphics g, int componentKey) {
        setImageIcon(component, g, componentKey, 0);
    }

    /**
     * Set component's image.
     *
     * @param component    Who need set image.
     * @param g            Graphics.
     * @param componentKey The component key.
     * @param index        Multi image find by index.
     */
    public static void setImageIcon(JComponent component, Graphics g, int componentKey, int index) {
        Image img = null;
        try {
            img = ImageIO.read(getURL(componentKey, index));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, 0, 0, Integer.parseInt(getSystemConfigByKey("DEFAULT_TOOLICON_WIDTH")),
                Integer.parseInt(getSystemConfigByKey("DEFAULT_TOOLICON_HEIGHT")), component);
    }

    /**
     * Get image url by component key and component index.
     *
     * @param componentKey Component key.
     * @param index        Component index.
     * @return Image URL.
     */
    private static URL getURL(int componentKey, int index) {
        StringBuffer imageIconPath = new StringBuffer();
        imageIconPath.append("IMAGE_ICON_PATH_");
        imageIconPath.append(componentKey);
        imageIconPath.append("_");
        imageIconPath.append(index);
        URL url = ImageUtil.class.getResource(getImageIconPathByKey(imageIconPath.toString()));
        return url;
    }

    /**
     * Get image icon by component key and component index.
     *
     * @param componentKey Component key.
     * @param index        Component index.
     * @return Image icon
     */
    public static ImageIcon getImageIconByComponentKeyAndIndex(int componentKey, int index) {
        ImageIcon imageIcon = new ImageIcon(getURL(componentKey, index));
        return imageIcon;
    }

    /**
     * Get image icon by component key and component index.
     *
     * @param componentKey Component key.
     * @param index        Component index.
     * @param width        Image width.
     * @param height       Image height.
     * @return Image icon
     */
    public static ImageIcon getImageIconByComponentKeyAndIndex(int componentKey, int index, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(getURL(componentKey, index));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }

    @Override
    public String getLoggerClassName() {
        return ImageUtil.class.getName();
    }
}
