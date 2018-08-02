import com.alibaba.fastjson.JSON;
import model.Models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Yang.jing on 18/4/15.
 */
public class TestMain {
    public static void main(String[] args) {
        String payload = "{\"start\":\"20180130214157805-0800\",\"end\":\"2018-05-08 11:11:11\",\"lpUid\":\"43603487018844016\"}";

        Models result = JSON.parseObject(payload, Models.class);
        Models resultB = JSON.toJavaObject(JSON.parseObject(payload), Models.class);

        System.out.println(JSON.toJSON(resultB));

    }


    public static String removeZeroAfterDot(String str) {

        if (str.endsWith("00")) {
            String[] strs = str.split("\\.");
            return strs[0];
        }

        if(str.endsWith("0")){
            return str.substring(0, str.length() - 1);
        }

        return str;

    }

}
