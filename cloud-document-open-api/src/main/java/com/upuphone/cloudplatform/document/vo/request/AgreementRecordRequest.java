package com.upuphone.cloudplatform.document.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname AgreementRecordRequest
 * @Description 用户协议记录
 * @Date 2022/7/8 9:52 上午
 * @Created by gz-d
 */
@ApiModel(value = "用户协议记录请求")
@Getter
@Setter
public class AgreementRecordRequest {
    @ApiModelProperty(value = "协议id", required = true)
    private String documentDetailId;
    @ApiModelProperty(value = "用户id", required = true)
    private String userId;
}
