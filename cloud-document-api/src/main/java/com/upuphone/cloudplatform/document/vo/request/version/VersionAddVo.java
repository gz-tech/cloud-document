package com.upuphone.cloudplatform.document.vo.request.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Classname VersionAddVo
 * @Description TODO
 * @Date 2022/6/29 5:34 下午
 * @Created by gz-d
 */
@ApiModel(value = "新增文案")
@Getter
@Setter
public class VersionAddVo {
    @ApiModelProperty(value = "语种", required = true)
    private String language;

    @ApiModelProperty(value = "文案内容类型文案内容类型.0-文本，1-图片，2-视频，3-富文本，4-附件", required = true)
    @NotNull(message = "文案内容类型不为空")
    private Integer contentType;

    @ApiModelProperty(value = "内容", required = true)
    @NotBlank(message = "文案内容不为空")
    private String content;
}
