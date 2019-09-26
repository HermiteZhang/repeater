package top.hermite.repeater.pigeon.core.base.service;

import top.hermite.repeater.pigeon.core.base.model.BaseEntity;
import top.hermite.repeater.pigeon.core.base.model.dto.BaseResultDto;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 17:21 2019/9/26
 * @Desc:
 */
public interface IBaseService <T extends BaseEntity> {

    /**
     * 根据Id查询实体
     */
    BaseResultDto getEntityById(final String id);

    /**
     * 查询全部
     */
    BaseResultDto listAll();

    /**
     * 新增实体
     */
    BaseResultDto insert(final T entity);

    /**
     * 更新实体
     */
    BaseResultDto update(final T entity);

    /**
     * 根据Id删除实体
     */
    BaseResultDto deleteById(final String id);

}