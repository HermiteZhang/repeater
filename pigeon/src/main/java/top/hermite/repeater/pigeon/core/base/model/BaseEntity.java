package top.hermite.repeater.pigeon.core.base.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;
import top.hermite.repeater.pigeon.core.component.util.IDGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 14:40 2019/9/26
 * @Desc:
 */
@Data
@NameStyle(value = Style.camelhumpAndLowercase)
public  class BaseEntity implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("pdId")
    private String pdId;

    public String getPdId() {
        if (pdId == null) {
            pdId = IDGenerator.generateID();
        }
        return pdId;
    }

    /**
     * 创建时间
     */
    @Column
    private Date pdCreateTime;

    /**
     * 最后修改时间
     */
    @Column
    private Date pdAlterTime;
}
