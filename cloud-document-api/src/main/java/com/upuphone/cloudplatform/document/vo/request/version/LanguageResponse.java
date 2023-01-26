package com.upuphone.cloudplatform.document.vo.request.version;

import com.upuphone.cloudplatform.document.vo.reponse.version.LanguageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Classname LanguageResponse
 * @Description
 * @Date 2022/6/30 2:37 下午
 * @Created by gz-d
 */
@ApiModel("语言列表 response")
@Getter
@Setter
public class LanguageResponse {
    @ApiModelProperty(value = "语种list")
    List<LanguageVo> languageList;
}
