package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.pojo.BasePojo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public abstract class BaseServiceImpl<T extends BasePojo> {

    @Autowired
    private BaseMapper<T> mapper;

    public T queryById(Long id) {
        return this.mapper.selectById(id);
    }
    /**
     * 查询所有数据
     */
    public List<T> queryAll() {
        return this.mapper.selectList(null);
    }
    /**
     * 根据条件查询一条数据
     */
    public T queryOne(T record) {
        return this.mapper.selectOne(new QueryWrapper<>(record));
    }
    /**
     * 根据条件查询数据列表
    */
    public List<T> queryListByWhere(T record) {
        return this.mapper.selectList(new QueryWrapper<>(record));
    }
    /**
     * 根据条件分页查询数据列表
     */
    public IPage<T> queryPageListByWhere(T record, Integer page, Integer rows) {
        // 获取分页数据
        return this.mapper.selectPage( new Page<T>(page,rows),
                new QueryWrapper<>(record) );
    }

    public Integer save(T record) {
        record.setCreated(new Date());
        record.setUpdated(record.getCreated());
        return this.mapper.insert(record);
    }

    /**
     * 更新数据
    */
    public Integer update(T record) {
        record.setUpdated(new Date());
        return this.mapper.updateById(record);
    }

    /**
      * 根据id删除数据
    */
    public Integer deleteById(Long id) {
        return this.mapper.deleteById(id);
    }

    /**
    * 根据ids批量删除数据
    */
    public Integer deleteByIds(List<Long> ids) {
        return this.mapper.deleteBatchIds(ids);
    }

    /**
     * 根据条件删除数据
     */
    public Integer deleteByWhere(T record){
        return this.mapper.delete(new QueryWrapper<>(record));
    }

    protected IPage<T> queryPageList(QueryWrapper<T> queryWrapper, int pageNum, int pageSize) {
        return  this.mapper.selectPage(new Page<T>(pageNum,pageSize),queryWrapper);
    }
}
