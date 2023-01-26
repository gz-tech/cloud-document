package com.upuphone.cloudplatform.document.vo.request.document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:03
 * @Version 1.0
 */
@ApiModel(value = "文案查询")
@Getter
@Setter
public class DocumentListRequest {
    @ApiModelProperty(value = "类型名称", required = true)
    private String name;

    @ApiModelProperty(value = "类型id（非主键，前端展示）", required = true)
    private String typeId;

    @ApiModelProperty(value = "分页大小", required = true)
    @NotNull(message = "page size不为空")
    private Integer pageSize;

    @ApiModelProperty(value = "分页数", required = true)
    @NotNull(message = "页码不为空")
    private Integer pageNum;
}
