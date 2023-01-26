package com.upuphone.cloudplatform.document.vo.reponse.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname DocumentDetailVo
 * @Description
 * @Date 2022/7/8 4:36 下午
 * @Created by gz-d
 */
@ApiModel("文案/协议详情")
@Setter
@Getter
public class DocumentDetailVo {
    @ApiModelProperty(value = "文案/协议详情id")
    private String id;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "语种")
    private String language;
    @ApiModelProperty(value = "内容类型")
    private String contentType;
}
