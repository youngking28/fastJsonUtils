import java.math.BigDecimal;

/**
 * Created by Yang.jing on 18/4/15.
 */
public class TestMain {
    public static void main(String[] args) {
        String payload = "{\n" +
                "    \"code\": 200,\n" +
                "    \"data\": {\n" +
                "        \"user_order_status\": \"ORDER_UNPAY\", \n" +
                "\n" +
                "        \"auction_intime_info\": { \n" +
                "            \"start_at\": \"2018-04-04 15:41:36\",  \n" +
                "            \"delay_time\": 5,\n" +
                "            \"bid_count\": 28, \n" +
                "            \"top_three_bidding\": [ \n" +
                "                {\n" +
                "                    \"price\": 3350.00,\n" +
                "                    \"user_phone\": \"15869032212\",\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"price\": 3300.00,\n" +
                "                    \"user_phone\": \"15087398223\",\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"price\": 3250.00,\n" +
                "                    \"user_phone\": \"13789032657\",\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "\n" +
                "        \"auction_promotion_info\": {\n" +
                "            \"sign_up_number\": 50, \n" +
                "            \"online_number\": 7834, \n" +
                "            \"status\": \"TYP_NOT_STARTED\", \n" +
                "            \"start_date\": \"2018-03-15 13:08:33\", \n" +
                "            \"end_date\": \"2018-03-15 13:08:33\", \n" +
                "            \"reality_end_at\" : \"2018-03-15 13:08:33\", \n" +
                "            \"city\": \"杭州市\", //\n" +
                "            \"logo_url\": \"http://dkongjian.dkongjian.cn/2017/11/22/1511332611128-750byrizqich2frl0bt59g4x6r.jpg\",\n" +
                "            \"cash_deposit\": \"11.00\", \n" +
                "            \"offset_price\": \"11.00\", \n" +
                "            \"reserve_price\": \"11.00\", \n" +
                "            \"rel_price\": \"2.00\", \n" +
                "            \"image_url\": \"http://dkongjian.dkongjian.cn/2017/11/22/1511332611128-750byrizqich2frl0bt59g4x6r.jpg\", \n" +
                "            \"product_name\": \"欧派橱柜\", \n" +
                "            \"delay_time\": 5, \n" +
                "            \"alias\": \"yxmf\", \n" +
                "            \"vendor_uid\": \"121231231\", \n" +
                "            \"site_vendor_uid\": \"32446456\", \n" +
                "            \"platform_site_uid\": \"43656476586\", \n" +
                "            \"product_detail\": [\n" +
                "                {\n" +
                "                    \"image_url\": \"http://dkongjian.dkongjian.cn/2017/11/22/1511332611128-750byrizqich2frl0bt59g4x6r.jpg\", \n" +
                "                    \"memo\": \"先到先得\", \n" +
                "                },\n" +
                "                {\n" +
                "                    \"image_url\": \"http://dkongjian.dkongjian.cn/2017/11/22/1511332611128-750byrizqich2frl0bt59g4x6r.jpg\", \n" +
                "                    \"memo\": \"先到先得\", \n" +
                "                },\n" +
                "                {\n" +
                "                    \"image_url\": \"http://dkongjian.dkongjian.cn/2017/11/22/1511332611128-750byrizqich2frl0bt59g4x6r.jpg\", \n" +
                "                    \"memo\": \"先到先得\", \n" +
                "                }\n" +
                "            ],\n" +
                "            \"product_service\": {\n" +
                "                \"installation\": \"TYP_SHOP_CONSULT\", \n" +
                "                \"logistics\": \"TYP_DOWNTOWN_FREE\", \n" +
                "                \"warranty_period\": \"1\", \n" +
                "                \"memo\": \"来吧\" \n" +
                "            },\n" +
                "            \"promotion_members\": [ \n" +
                "                {\n" +
                "                    \"bind_shop_phone\": \"15068186989\",\n" +
                "                    \"city\": \"杭州市\",\n" +
                "                    \"logo_url\": \"http://dkongjian.dkongjian.cn/2017/11/22/1511332611128-750byrizqich2frl0bt59g4x6r.jpg\",\n" +
                "                    \"bind_shop_uid\": \"43397603343057106\",\n" +
                "                    \"member_user_uid\": \"\",\n" +
                "                    \"promotion_uid\": \"43397603819187802\",\n" +
                "                    \"bind_shop_name\": \"Block测试门店\",\n" +
                "                    \"sub_promotion_uid\": \"43397603819187803\",\n" +
                "                    \"promotion_type\": \"TYP_BAYMAX_LOTTERY\",\n" +
                "                    \"bind_shop_address\": \"浙江省杭州市江干区金沙港6幢\",\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"error_msg\": \"\"\n" +
                "}";
        BigDecimal result = FastJsonUtils.getValue(payload, "price", BigDecimal.class);
//        String result = FastJsonUtils.getString(payload, "price");
        System.out.println(result);

    }
}
