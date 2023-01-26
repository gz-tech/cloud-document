package com.upuphone.cloudplatform.document.vo.request.document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:04
 * @Version 1.0
 */
@ApiModel(value = "新增文案")
@Getter
@Setter
public class DocumentAddRequest {
    @ApiModelProperty(value = "文案名称", required = true)
    @NotBlank(message = "文案名称不为空")
    @Length(max = 50, message = "文案名称不超过50")
    private String name;
}
