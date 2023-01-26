package com.upuphone.cloudplatform.document.vo.reponse.version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 语种response
 */
@ApiModel(value = "语种response")
@Getter
@Setter
public class LanguageVo {
    @ApiModelProperty(value = "英文名", required = true)
    private String en;
    @ApiModelProperty(value = "中文名", required = true)
    private String cn;
}
