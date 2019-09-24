package top.hermite.repeater.pigeon.service;

import top.hermite.repeater.pigeon.model.PigeonRepeaterEntity;

import java.util.List;

public interface PigeonRepeaterServ <T extends PigeonRepeaterEntity>  {
    /**
     * 根据Id查询实体
     */
    T getEntityById(final Integer id);

    /**
     * 新增实体
     */
    void addEntity(final T entity);
    /**
     * 更新实体
     */
    void updateEntity(final T entity);

    /**
     * 根据Id删除实体
     */
    void deleteEntityById(final Integer id);

    /**
     * 查询所有
     */
    List<T> selectAll();
}

