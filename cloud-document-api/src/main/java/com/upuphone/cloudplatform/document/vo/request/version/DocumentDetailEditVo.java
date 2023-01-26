package com.upuphone.cloudplatform.document.vo.request.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Classname DocumentEditVo
 * @Description TODO
 * @Date 2022/6/29 5:49 下午
 * @Created by gz-d
 */
@ApiModel(value = "编辑文案")
@Getter
@Setter
public class DocumentDetailEditVo {
    @ApiModelProperty(value = "id", required = true)
    private String id;

    @ApiModelProperty(value = "语种", required = true)
    private String language;

    @ApiModelProperty(value = "文案内容类型", required = true)
    private String contentType;

    @ApiModelProperty(value = "文案内容", required = true)
    @NotBlank(message = "文案内容不为空")
    private String content;
}
