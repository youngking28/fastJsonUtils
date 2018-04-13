import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Yang.jing on 18/4/13.
 */
public class FastJsonUtils {

    /**
     * 直接获取第一个key相同的string
     *
     * @param payload
     * @param key
     * @return
     */

    public static String getString(String payload, String key) {
        JSONObject payloadJson = JSON.parseObject(payload);
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
}
