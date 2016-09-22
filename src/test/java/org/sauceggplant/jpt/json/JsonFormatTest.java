package org.sauceggplant.jpt.json;

import org.sauceggplant.jpt.log.AbstractLogger;
import org.testng.annotations.Test;

import static org.sauceggplant.jpt.json.JsonFormat.formatJson;

/**
 * Json format test.
 *
 * @author zhaozx
 * @version 1.0.0.1
 */
public class JsonFormatTest extends AbstractLogger {

    @Override
    public String getLoggerClassName() {
        return JsonFormatTest.class.getName();
    }

    @Test
    public void jsonFormatTest() {
        String json = "[{\"nsrsbh\":\"44444\",\"nsrmc\":\"aaaaaa\",\"nsrbp\":{\"tableName\":\"go_paint\",\"tableIndex\":123}},{\"nsrsbh\":\"333333\",\"nsrmc\":\"222222\"}]";
        getLogger().info("####input Json:");
        getLogger().info(json);
        getLogger().info("####parsed Json:");
        getLogger().info("\n" + formatJson(json));
    }
}
