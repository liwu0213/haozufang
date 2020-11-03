package cn.itcast.haoke.dubbo.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResult<T> {


    @JsonIgnore
    private String status;
    @JsonIgnore
    private String msg;
    @JsonIgnore
    private List<T> list;


    public static <T> WebResult<T> ok(List<T> list){
        return new WebResult<T>("200","ok",list);
    }

    public static <T> WebResult ok(List<T> list,String msg){
        return new WebResult("200",msg,list);
    }

    public Map<String, List<T>> getData() {
        HashMap<String,List<T>> data = new HashMap<String,List<T>>();
        data.put("list", this.list);
        return data;
    }
    public Map<String, Object> getMeta() {
        HashMap<String, Object> meta = new HashMap<String, Object>();
        meta.put("msg", this.msg);
        meta.put("status", this.status);
        return meta;
    }

}
