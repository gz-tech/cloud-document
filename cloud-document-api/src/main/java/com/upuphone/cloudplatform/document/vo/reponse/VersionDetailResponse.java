package com.upuphone.cloudplatform.document.vo.reponse;

import com.upuphone.cloudplatform.document.vo.reponse.version.DocumentDetailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Classname VersionDetailResponse
 * @Description 版本详情
 * @Date 2022/7/8 4:33 下午
 * @Created by gz-d
 */
@ApiModel("版本详情response")
@Getter
@Setter
public class VersionDetailResponse {
    @ApiModelProperty(value = "版本包含的各语种详情list")
    private List<DocumentDetailVo> documentDetailList;
}
