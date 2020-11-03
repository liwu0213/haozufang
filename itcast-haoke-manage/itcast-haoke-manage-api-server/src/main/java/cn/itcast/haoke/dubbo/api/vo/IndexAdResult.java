package cn.itcast.haoke.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IndexAdResult {

    private List<IndexAdResultData> list;

}
