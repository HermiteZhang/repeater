package top.hermite.repeater.pigeon.core.base.dao;

import top.hermite.repeater.pigeon.core.base.model.BaseEntity;

import java.util.List;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 16:39 2019/9/26
 * @Desc: 解耦数据实现层，对上级服务提供数据访问基本接口
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 根据Id查询实体
     */
    public T getEntityById(final Class<T> cls, final String id);

    /**
     * 查询全部
     */
    public List<T> listAll(Class<T> cls);

    /**
     * 新增实体
     */
    public void insert(final T entity);

    /**
     * 更新实体
     */
    public void update(final T entity);

    /**
     * 根据Id删除实体
     */
    public void delete(final Class<T> cls, final String id);
}
