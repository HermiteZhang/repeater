package top.hermite.repeater.pigeon.component.util;

import java.util.Date;
import java.util.UUID;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 10:35 2019/9/26
 * @Desc: 主键生成器
 */
public class IDGenerator {
    /**
     * 生成主键（32位）
     */
    public static String generateID() {
        return generateID(System.currentTimeMillis());
    }

    /**
     * 根据指定时间生成主键，该方法只能用来对比主键生成时间，切忌不能用来生成主键插入数据库
     */
    public static String generateID(Date date) {
        return generateID(date.getTime());
    }

    /**
     * 根据指定时间生成主键
     */
    public static String generateID(long time) {
        String rtnVal = Long.toHexString(time);
        rtnVal += UUID.randomUUID();
        rtnVal = rtnVal.replaceAll("-", "");
        return rtnVal.substring(0, 32);
    }

    /**
     * 查看主键生成时间
     */
    protected static void printIDTime(String id) {
        String timeInfo = id.substring(0, 11);
        System.out.println(new Date(Long.parseLong(timeInfo, 16)));
    }

    /**
     * 根据ID获取该ID创建的时间
     */
    public static Date getIDCreateTime(String id) {
        String timeInfo = id.substring(0, 11);
        return new Date(Long.parseLong(timeInfo, 16));
    }
}
