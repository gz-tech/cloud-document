package com.upuphone.cloudplatform.document.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Blob;
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
@TableName("user_agreement")
public class UserAgreementPo extends Model<UserAgreementPo> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long docDetailId;

    /**
     * 0-同意，1-拒绝
     */
    private Integer isAgree;

    /**
     * 设备类型0-PC, 1-手机,2-平板,3-移动web,4-car,5-vr,-1=未知
     */
    private Integer deviceType;

    private String deviceId;

    private Blob extra;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createBy;

    private String updateBy;

    private Integer isDeleted;
}
