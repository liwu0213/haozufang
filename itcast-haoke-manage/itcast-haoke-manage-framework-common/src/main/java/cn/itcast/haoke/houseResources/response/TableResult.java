package cn.itcast.haoke.houseResources.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableResult<T> {
    private List<T> list;
    private Pagination pagination;
}
