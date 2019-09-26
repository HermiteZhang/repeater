package top.hermite.repeater.pigeon.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 17:38 2019/9/26
 * @Desc:  标记mapper的class类名
 */

@SuppressWarnings("unchecked")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapperClass{
	/**
	 *指定 MapperClass
	 */
    Class value();
}