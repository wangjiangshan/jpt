package org.sauceggplant.jpt.util;

import org.sauceggplant.jpt.log.AbstractLogger;

import java.io.InputStream;
import java.util.Properties;

/**
 * Properties file read.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public final class PropertiesUtil extends AbstractLogger {

    /**
     * Properties of dictionary.
     */
    private static Properties dictionaryProperties = new Properties();

    /**
     * Properties of germany.
     */
    private static Properties de_DEProperties = new Properties();

    /**
     * Properties of english.
     */
    private static Properties en_USProperties = new Properties();

    /**
     * Properties of france.
     */
    private static Properties fr_FRProperties = new Properties();

    /**
     * Properties of japanese.
     */
    private static Properties ja_JPProperties = new Properties();

    /**
     * Properties of korea.
     */
    private static Properties ko_KRProperties = new Properties();

    /**
     * Properties of chinese.
     */
    private static Properties zh_CNProperties = new Properties();

    /**
     * Properties of taiwan.
     */
    private static Properties zh_TWProperties = new Properties();

    /**
     * Properties of system config.
     */
    private static Properties configProperties = new Properties();

    /**
     * Properties of all image icon file path.
     */
    private static Properties imageIconProperties = new Properties();

    /**
     * Constructor,init all properties.
     */
    public PropertiesUtil() {

        try {
            InputStream dictionaryInputStream = Properties.class.getResourceAsStream("/component/dictionary.properties");
            InputStream de_DEInputStream = Properties.class.getResourceAsStream("/language/de_DE.properties");
            InputStream en_USInputStream = Properties.class.getResourceAsStream("/language/en_US.properties");
            InputStream fr_FRInputStream = Properties.class.getResourceAsStream("/language/fr_FR.properties");
            InputStream ja_JPInputStream = Properties.class.getResourceAsStream("/language/ja_JP.properties");
            InputStream ko_KRInputStream = Properties.class.getResourceAsStream("/language/ko_KR.properties");
            InputStream zh_CNInputStream = Properties.class.getResourceAsStream("/language/zh_CN.properties");
            InputStream zh_TWInputStream = Properties.class.getResourceAsStream("/language/zh_TW.properties");
            InputStream configInputStream = Properties.class.getResourceAsStream("/system/config.properties");
            InputStream imageIconInputStream = Properties.class.getResourceAsStream("/system/imagePath.properties");

            dictionaryProperties.load(dictionaryInputStream);
            de_DEProperties.load(de_DEInputStream);
            en_USProperties.load(en_USInputStream);
            fr_FRProperties.load(fr_FRInputStream);
            ja_JPProperties.load(ja_JPInputStream);
            ko_KRProperties.load(ko_KRInputStream);
            zh_CNProperties.load(zh_CNInputStream);
            zh_TWProperties.load(zh_TWInputStream);
            configProperties.load(configInputStream);
            imageIconProperties.load(imageIconInputStream);

        } catch (Exception e) {
            getLogger().error("####" + e.getMessage());
        }
    }

    //Getters of properties.
    public static Properties getDictionaryProperties() {
        return dictionaryProperties;
    }

    public static Properties getDe_DEProperties() {
        return de_DEProperties;
    }

    public static Properties getEn_USProperties() {
        return en_USProperties;
    }

    public static Properties getFr_FRProperties() {
        return fr_FRProperties;
    }

    public static Properties getJa_JPProperties() {
        return ja_JPProperties;
    }

    public static Properties getKo_KRProperties() {
        return ko_KRProperties;
    }

    public static Properties getZh_CNProperties() {
        return zh_CNProperties;
    }

    public static Properties getZh_TWProperties() {
        return zh_TWProperties;
    }

    public static Properties getConfigProperties() {
        return configProperties;
    }

    public static Properties getImageIconProperties() {
        return imageIconProperties;
    }

    public String getLoggerClassName() {
        return PropertiesUtil.class.getName();
    }

}
