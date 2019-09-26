package top.hermite.repeater.pigeon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import top.hermite.repeater.pigeon.component.util.IDGenerator;

import java.util.Date;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 10:31 2019/9/26
 * @Desc: 组织架构元素，所有组织架构类的父类
 */
@Data
public class OrgElement {

    /**
     * 主键
     */
    protected String pdId;

    public String getPdId() {
        if (pdId == null) {
            pdId = IDGenerator.generateID();
        }
        return pdId;
    }

    /**
     * 类型
     */
    private Integer pdType;

    /**
     * 名称
     */
    private String pdName;


    /**
     * 编号/工号
     */
    private String pdNo;

    /**
     * 排序号
     */
    private Integer pdOrder;


    /**
     * 是否有效
     */
    private Boolean pdIsAvailable;
    /**
     * 是否已废弃,true表示禁用
     */
    protected Boolean pdIsAbandon = new Boolean(false);
    /**
     * 描述
     */
    private String pdDesc;

    /**
     * 创建时间
     */
    private Date pdCreateTime = new Date();
    /**
     * 最后修改时间
     */
    private Date pdAlterTime = new Date();


}
