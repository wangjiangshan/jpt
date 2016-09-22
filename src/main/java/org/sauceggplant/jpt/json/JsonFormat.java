package org.sauceggplant.jpt.json;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.ArrayList;

/**
 * Json string format.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public final class JsonFormat {

    /**
     * Format json,write into textPane.
     *
     * @param jsonParam Json data.
     * @param textPane  Used to write json.
     */
    public static void formatJson(String jsonParam, JTextPane textPane) {
        java.util.List colorList = new ArrayList();
        colorList.add(Color.BLUE);
        colorList.add(Color.GREEN);
        colorList.add(Color.RED);
        colorList.add(Color.ORANGE);
        textPane.setText("");
        formatJson(jsonParam, textPane, colorList);
    }

    /**
     * Format json string.
     *
     * @param jsonParam Source json.
     * @return Target json.
     */
    public static String formatJson(String jsonParam) {
        java.util.List colorList = new ArrayList();
        colorList.add(Color.BLUE);
        colorList.add(Color.GREEN);
        colorList.add(Color.RED);
        colorList.add(Color.ORANGE);
        return formatJson(jsonParam, null, colorList);
    }

    /**
     * Format json string.
     *
     * @param jsonParam Source json.
     * @param textPane  Used to write json.
     * @param colorList Write json data into textPane,font color.
     * @return Target json.
     */
    public static String formatJson(String jsonParam, JTextPane textPane, java.util.List<Color> colorList) {
        if (null == jsonParam || "".equals(jsonParam)) {
            insertDocument("", colorList.get(0), textPane);
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        //Last char in jsonParam.
        char last = '\0';
        //Current char in jsonParam.
        char current = '\0';
        //Level used to describe how many blank need to print.
        int level = 0;
        //The current char is a ' ','\t','\n' in jsonParam.
        boolean charInString = false;
        boolean isNum = false;
        //Format error.
        boolean hasError = false;

        for (int i = 0; i < jsonParam.length(); i++) {
            last = current;
            current = jsonParam.charAt(i);
            if (hasError) {
                break;
            }

            switch (current) {
                case '\"':
                    if (last != '\\') {
                        if (!charInString) {
                            charInString = true;
                        } else {
                            charInString = false;
                        }
                        insertDocument("\"", colorList.get(1), textPane);
                    } else {
                        if (!charInString) {
                            charInString = false;
                        } else {
                            charInString = true;
                        }
                        insertDocument("\"", colorList.get(3), textPane);
                    }
                    stringBuilder.append("\"");
                    break;

                case '{':
                case '[':
                    if (!charInString) {
                        stringBuilder.append(current + "\n");
                        insertDocument(current + "\n", colorList.get(0), textPane);
                        level++;
                        addLevelBlank(stringBuilder, level, textPane);
                        break;
                    } else {
                        stringBuilder.append(current);
                        insertDocument("" + current, colorList.get(3), textPane);
                        break;
                    }

                case '}':
                case ']':
                    if (!charInString) {
                        stringBuilder.append('\n');
                        insertDocument("\n", colorList.get(0), textPane);
                        level--;
                        addLevelBlank(stringBuilder, level, textPane);
                        stringBuilder.append(current);
                        insertDocument("" + current, colorList.get(0), textPane);
                        break;
                    } else {
                        stringBuilder.append(current);
                        insertDocument("" + current, colorList.get(3), textPane);
                        break;
                    }

                case ',':
                    if (!charInString) {
                        stringBuilder.append(current);
                        insertDocument("" + current, colorList.get(0), textPane);
                        if (last != '\\') {
                            stringBuilder.append('\n');
                            insertDocument("\n", colorList.get(0), textPane);
                            addLevelBlank(stringBuilder, level, textPane);
                        }
                        break;
                    } else {
                        stringBuilder.append(current);
                        insertDocument("" + current, colorList.get(3), textPane);
                        break;
                    }

                case '\n':
                case ' ':
                case '\t':
                    if (!charInString) {
                        break;
                    } else {
                        stringBuilder.append(current);
                        insertDocument("" + current, colorList.get(3), textPane);
                        break;
                    }

                case ':':
                    if (!charInString) {
                        stringBuilder.append(" : ");
                        insertDocument(" : ", colorList.get(0), textPane);
                        break;
                    } else {
                        stringBuilder.append(current);
                        insertDocument("" + current, colorList.get(3), textPane);
                        break;
                    }

                default:
                    if (charInString) {
                        stringBuilder.append(current);
                        if (current >= 48 && current <= 57) {
                            insertDocument("" + current, colorList.get(2), textPane);
                        } else if ('\\' == current
                                || current >= 33 && current <= 47
                                || current >= 59 && current <= 64
                                || current >= 94 && current <= 96
                                || current == 124
                                || current == 126) {
                            insertDocument("" + current, colorList.get(3), textPane);
                        } else {
                            insertDocument("" + current, colorList.get(1), textPane);
                        }
                    } else if (current >= 48 && current <= 57) {
                        insertDocument("" + current, colorList.get(2), textPane);
                    } else if ('n' == current) {
                        if (jsonParam.charAt(i + 1) == 'u' && jsonParam.charAt(i + 2) == 'l' && jsonParam.charAt(i + 3) == 'l') {
                            insertDocument("null", colorList.get(0), textPane);
                            i += 3;
                        } else {
                            if (!hasError) {
                                JOptionPane.showMessageDialog(null, "Format json error! " + current + " at " + i + " char.");
                                hasError = true;
                            }
                        }
                    } else if ('N' == current) {
                        if (jsonParam.charAt(i + 1) == 'U' && jsonParam.charAt(i + 2) == 'L' && jsonParam.charAt(i + 3) == 'L') {
                            insertDocument("null", colorList.get(0), textPane);
                            i += 3;
                        } else {
                            if (!hasError) {
                                JOptionPane.showMessageDialog(null, "Format json error! " + current + " at " + i + " char.");
                                hasError = true;
                            }
                        }
                    } else {
                        if (!hasError) {
                            JOptionPane.showMessageDialog(null, "Format json error! " + current + " at " + i + " char.");
                            hasError = true;
                        }
                    }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Add text into textPane.
     *
     * @param text      Content.
     * @param textColor Font color.
     * @param textPane  Used to write content.
     */
    public static void insertDocument(String text, Color textColor, JTextPane textPane) {
        if (textPane != null) {
            SimpleAttributeSet set = new SimpleAttributeSet();
            StyleConstants.setForeground(set, textColor);
            StyleConstants.setFontSize(set, 18);
            StyleConstants.setBold(set, true);
            StyleConstants.setFontFamily(set, "\u5b8b\u4f53");
            Document doc = textPane.getStyledDocument();
            try {
                doc.insertString(doc.getLength(), text, set);
            } catch (BadLocationException e) {
                e.printStackTrace();
                //getLogger().error(e.getMessage());
            }
        }
    }

    /**
     * Add blank in json.
     *
     * @param stringBuilder Json string.
     * @param currentLevel  Json level.
     * @param textPane      Used to write json.
     */
    private static void addLevelBlank(StringBuilder stringBuilder, int currentLevel, JTextPane textPane) {
        if (textPane != null) {
            for (int level = 0; level < currentLevel; level++) {
                //stringBuilder.append("\t");
                stringBuilder.append("    ");
                insertDocument("    ", Color.BLUE, textPane);
            }
        } else {
            for (int level = 0; level < currentLevel; level++) {
                //stringBuilder.append("\t");
                stringBuilder.append("    ");
            }
        }
    }

}
