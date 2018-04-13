import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Yang.jing on 18/4/13.
 */
public class FastJsonUtils {

    private static final SerializerFeature[] FEATURES = {
            // 输出空置字段
            SerializerFeature.WriteMapNullValue,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullListAsEmpty,
            // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullNumberAsZero,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteNullStringAsEmpty,
            //采用默认时间格式输出
            SerializerFeature.WriteDateUseDateFormat
    };

    /**
     * 直接获取第一个key相同的string
     *
     * @param payload
     * @param key
     * @return
     */

    public static String getString(String payload, String key) {
        JSONObject payloadJson = JSON.parseObject(payload);
        return getString(payloadJson, key);
    }

    public static String getString(JSONObject payloadJson, String key) {
        Set entrySet = payloadJson.entrySet();

        String result;
        for (Object entry : entrySet) {
            HashMap.Entry entryNode = (HashMap.Entry) entry;

            String innerKey = String.valueOf(entryNode.getKey());

            if (innerKey.equals(key) && entryNode.getValue() instanceof String) {
                return String.valueOf(entryNode.getValue());
            } else {
                if (entryNode.getValue() instanceof JSONObject) {
                    return getString(String.valueOf(payloadJson.getString(innerKey)), key);
                } else if (entryNode.getValue() instanceof JSONArray) {
                    JSONArray jarray = (JSONArray) entryNode.getValue();
                    for (Object jo : jarray) {
                        result = getString(JSON.toJSONString(jo), key);
                        if(StringUtils.isNotBlank(result)){
                            return result;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }


        /**
         * <pre>
         * 将对象转为json,下划线输出
         * 时间格式按照 2012-01-01 12:12:12<>
         * fastjson缺省使用CamelCase，在1.2.15版本之后，fastjson支持配置PropertyNamingStrategy
         * </pre>
         *
         * @param object
         * @return
         */
    public static String toSnakeCaseJSONString(Object object) {
        SerializeConfig config = new SerializeConfig();

        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;

        return JSON.toJSONString(object, config, FEATURES);
    }
}
