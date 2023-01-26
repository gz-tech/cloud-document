package com.upuphone.cloudplatform.document.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author guangzheng.ding
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("document")
public class DocumentPo extends Model<DocumentPo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文案类型id，e.g.B00001
     */
    private String typeId;

    private String name;

    private String updateBy;

    private LocalDateTime updateTime;

    private String createBy;

    private LocalDateTime createTime;

    private Integer isDeleted;
}
