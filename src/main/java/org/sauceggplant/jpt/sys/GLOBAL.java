package org.sauceggplant.jpt.sys;

import org.sauceggplant.jpt.util.PropertiesUtil;

import java.util.Properties;

/**
 * System properties and global static values.
 * This is a final class,include all of the system config and params.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public final class GLOBAL {

    /**
     * Properties files to read.
     */
    private static final PropertiesUtil propertiesUtil = new PropertiesUtil();

    /**
     * Get system config by key./system/config.properties
     *
     * @param key Property.
     * @return Value.
     */
    public static String getSystemConfigByKey(String key) {
        return propertiesUtil.getConfigProperties().getProperty(key);
    }

    /**
     * Get image path config by key./system/imagePath.properties
     *
     * @param key Property.
     * @return Value.
     */
    public static String getImageIconPathByKey(String key) {
        return propertiesUtil.getImageIconProperties().getProperty(key);
    }

    /**
     * Component key is the index of the component.dictionary property:"COMPONENT"+key,value is the component code.
     * Component code is the component type.used to get component name.
     * Component name is a name that how we can call the component.
     *
     * @param key Component index.
     * @return Component code.
     */
    public static String getComponentCodeByKey(int key) {
        return propertiesUtil.getDictionaryProperties().getProperty(String.valueOf("COMPONENT" + key));
    }

    /**
     * Get component title code by index.dictionary property:"TITLE"+key,value is the component title code.
     * Component title code is used to get component real name to view.
     *
     * @param key Index of component.
     * @return Component title code,used to get component real title(name).
     */
    public static String getComponentTitleCodeByKey(int key) {
        return propertiesUtil.getDictionaryProperties().getProperty(String.valueOf("TITLE" + key));
    }

    /**
     * Get component title code by index.dictionary property:"TITLE"+key+"_"+index,value is the component title code.
     * Component title code is used to get component real name to view.
     *
     * @param key   Index of component.
     * @param index Index of this component's title.
     * @return Component title code,used to get component real title(name).
     */
    public static String getComponentTitlesCodeByKey(int key, int index) {
        return propertiesUtil.getDictionaryProperties().getProperty(String.valueOf("TITLE" + key + "_" + index));
    }

    /**
     * Get component title by index.
     *
     * @param key Index of component.
     * @return Component title.
     */
    public static String getComponentTitleByKey(int key) {
        return getLanguageProperties(getDefaultLanguage()).getProperty(getComponentTitleCodeByKey(key));
    }

    /**
     * Get component title by index.
     *
     * @param key   Index of component.
     * @param index Index of this component's title.
     * @return Component title.
     */
    public static String getComponentTitlesByKey(int key, int index) {
        return getLanguageProperties(getDefaultLanguage()).getProperty(getComponentTitlesCodeByKey(key, index));
    }

    /**
     * Get component name by index.
     *
     * @param key Index of component.
     * @return Component name.
     */
    public static String getComponentNameByKey(int key) {
        return getLanguageProperties(getDefaultLanguage()).getProperty(getComponentCodeByKey(key));
    }

    /**
     * System language,/system/config.properties: LANGUAGE
     *
     * @return short for the language description when current used.
     */
    public static String getDefaultLanguage() {
        return getSystemConfigByKey("LANGUAGE");
    }

    /**
     * Get the properties by the language type.
     *
     * @param language short for the language description.
     * @return Language properties.
     */
    public static Properties getLanguageProperties(String language) {
        if (language == null) {
            return propertiesUtil.getEn_USProperties();
        } else if ("de_de".equals(language.toLowerCase())) {
            return propertiesUtil.getDe_DEProperties();
        } else if ("en_us".equals(language.toLowerCase())) {
            return propertiesUtil.getEn_USProperties();
        } else if ("fr_fr".equals(language.toLowerCase())) {
            return propertiesUtil.getFr_FRProperties();
        } else if ("ja_jp".equals(language.toLowerCase())) {
            return propertiesUtil.getJa_JPProperties();
        } else if ("ko_kr".equals(language.toLowerCase())) {
            return propertiesUtil.getKo_KRProperties();
        } else if ("zh_cn".equals(language.toLowerCase())) {
            return propertiesUtil.getZh_CNProperties();
        } else if ("zh_tw".equals(language.toLowerCase())) {
            return propertiesUtil.getZh_TWProperties();
        } else {
            return propertiesUtil.getEn_USProperties();
        }
    }
}
