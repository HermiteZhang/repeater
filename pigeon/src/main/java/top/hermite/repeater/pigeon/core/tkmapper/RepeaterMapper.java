package top.hermite.repeater.pigeon.core.tkmapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 15:10 2019/9/26
 * @Desc:
 */
@RegisterMapper
public interface RepeaterMapper<T> extends Mapper<T> {
}
