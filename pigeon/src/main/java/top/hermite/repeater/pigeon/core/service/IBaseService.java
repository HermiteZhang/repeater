package top.hermite.repeater.pigeon.core.service;

import java.util.List;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 17:21 2019/9/26
 * @Desc:
 */
public interface IBaseService <T> {

    /**
     * 根据Id查询实体
     */
     T getEntityById(final Integer id);

    /**
     * 查询全部
     */
     List<T> listAll();

    /**
     * 新增实体
     */
     void insert(final T entity);

    /**
     * 更新实体
     */
     void update(final T entity);

    /**
     * 根据Id删除实体
     */
     void deleteById(final Integer id);

}