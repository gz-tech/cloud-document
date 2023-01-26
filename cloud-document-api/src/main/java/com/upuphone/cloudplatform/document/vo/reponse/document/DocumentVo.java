package com.upuphone.cloudplatform.document.vo.reponse.document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:05
 * @Version 1.0
 */
@ApiModel(value = "类型")
@Getter
@Setter
public class DocumentVo {
    @ApiModelProperty(value = "类型主键id")
    private String id;

    @ApiModelProperty(value = "类型id")
    private String typeId;

    @ApiModelProperty(value = "类型名称")
    private String name;
}
