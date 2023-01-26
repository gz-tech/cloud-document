package com.upuphone.cloudplatform.document.vo.request.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Min.Jiang
 * @Date 2022/6/23 20:05
 * @Version 1.0
 */
@ApiModel(value = "新增文案")
@Getter
@Setter
public class VersionAddRequest {
    @ApiModelProperty(value = "文案list", required = true)
    private List<VersionAddVo> documentList;

    @ApiModelProperty(value = "文案类型id（主键）", required = true)
    private String documentId;
}
