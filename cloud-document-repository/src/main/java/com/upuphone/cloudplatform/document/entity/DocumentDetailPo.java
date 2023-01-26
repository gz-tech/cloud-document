package com.upuphone.cloudplatform.document.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("document_detail")
public class DocumentDetailPo extends Model<DocumentDetailPo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联文案版本 版本号主键
     */
    private Long documentVersion;
    /**
     * 客户端展示版本号 ---100，101
     */
    @TableField(exist = false)
    private String versionId;

    /**
     * 语种
     */
    private String language;

    /**
     * 文案内容类型0-文本，1-图片，2-视频，3-富文本
     */
    private Integer contentType;

    /**
     * 文本内容
     */
    private String content;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private Integer isDeleted;

}
