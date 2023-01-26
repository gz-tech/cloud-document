package com.upuphone.cloudplatform.document.vo.request.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author Min.Jiang
 * @Date 2022/6/23 19:05
 * @Version 1.0
 */
@ApiModel(value = "编辑文案")
@Getter
@Setter
public class DocumentDetailEditRequest {
    @ApiModelProperty(value = "id", required = true)
    @Valid
    private List<DocumentDetailEditVo> documentDetailList;
    @ApiModelProperty(value = "versionId", required = true)
    private String versionId;
}
