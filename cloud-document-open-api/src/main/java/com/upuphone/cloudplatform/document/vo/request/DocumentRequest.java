package com.upuphone.cloudplatform.document.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Classname DocumentRequest
 * @Description 获取文案或协议
 * @Date 2022/6/23 1:59 下午
 * @Created by gz-d
 */
@Getter
@Setter
@ApiModel(value = "获取文案或协议 Request")
public class DocumentRequest {
    @ApiModelProperty(value = "文案类型id", required = true)
    @NotBlank(message = "文案类型id不为空")
    private String documentId;

    @ApiModelProperty(value = "语种", required = true)
    @NotBlank(message = "语种不为空")
    private String language;

    @ApiModelProperty(value = "目标版本号(需要获取特定版本文案时填，否则不填")
    private String targetVersionId;

    @ApiModelProperty(value = "当前版本号(当前文案版本号，第一次获取时不填")
    private String currentVersionId;

    @ApiModelProperty(value = "文本或h5， text-文本，h5-协议h5链接")
    private String type;

}
