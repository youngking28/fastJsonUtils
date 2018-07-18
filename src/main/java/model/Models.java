package model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Yang.jing on 18/5/8.
 */
public class Models {
    @JSONField(format = "yyyyMMddHHmmssSSSZ")
    private Date start;
    @JSONField(format = "yyyy-MM-dd")
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
