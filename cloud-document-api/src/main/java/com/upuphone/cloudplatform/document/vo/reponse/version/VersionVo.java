package com.upuphone.cloudplatform.document.vo.reponse.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Author Min.Jiang
 * @Date 2022/6/23 19:05
 * @Version 1.0
 */
@ApiModel(value = "文案版本")
@Getter
@Setter
public class VersionVo {
    @ApiModelProperty(value = "版本主键")
    private String id;
    @ApiModelProperty(value = "版本号")
    private String versionId;
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "更新者")
    private String updateBy;
}
