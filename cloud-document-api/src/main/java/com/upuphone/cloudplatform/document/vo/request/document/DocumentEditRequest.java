package com.upuphone.cloudplatform.document.vo.request.document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:04
 * @Version 1.0
 */
@ApiModel(value = "编辑文案")
@Getter
@Setter
public class DocumentEditRequest {
    @ApiModelProperty(value = "类型主键id", required = true)
    @NotNull(message = "id不为空")
    private Long id;

    @ApiModelProperty(value = "类型名称", required = true)
    @NotBlank(message = "类型名称不为空")
    @Length(max = 50, message = "文案名称不超过50")
    private String name;
}
