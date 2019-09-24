package top.hermite.repeater.pigeon.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Data
@NameStyle(value = Style.camelhumpAndLowercase)
public class PigeonRepeaterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    /**
     * 创建时间
     */
    @Column
    private Date createTime;
    /**
     * 最后修改时间
     */
    @Column
    private Date lastModifyTime;
}

