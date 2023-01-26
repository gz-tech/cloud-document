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
@TableName("document_version")
public class DocumentVersionPo extends Model<DocumentVersionPo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联文案类型
     */
    private Long documentId;

    /**
     * 版本号e.g. 100,101,102
     */
    private String versionId;

    private LocalDateTime createTime;

    private String createBy;

    private String updateBy;

    private LocalDateTime updateTime;

    private Integer isDeleted;

}
