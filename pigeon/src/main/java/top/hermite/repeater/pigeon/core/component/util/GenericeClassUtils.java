package top.hermite.repeater.pigeon.core.component.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 10:35 2019/9/26
 * @Desc: 获取类名
 */
public class GenericeClassUtils {

	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return null;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return null;
		}

		if (!(params[index] instanceof Class)) {
			return null;
		}
		return (Class) params[index];
	}
}