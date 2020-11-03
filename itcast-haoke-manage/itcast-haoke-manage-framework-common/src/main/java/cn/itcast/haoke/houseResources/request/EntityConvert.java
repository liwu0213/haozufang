package cn.itcast.haoke.houseResources.request;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;


import java.util.function.Supplier;

public interface EntityConvert<T,E> {

    default E convertToEntity(Supplier<E> e){
        E target = e.get();
        BeanUtil.copyProperties(this,target, CopyOptions.create().setIgnoreNullValue(true));
        return target;
    }
}
