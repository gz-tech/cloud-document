package com.upuphone.cloudplatform.document.vo.response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname DocumentResponse
 * @Description
 * @Date 2022/6/23 4:23 下午
 * @Created by gz-d
 */
@Getter
@Setter
@ApiModel(value = "app获取文案/协议response")
public class DocumentResponse {
    @ApiModelProperty(value = "协议版本号")
    private String versionId;
    @ApiModelProperty(value = "文案内容")
    private String text;
    @ApiModelProperty(value = "协议h5地址")
    private String htmlPlainText;
    @ApiModelProperty(value = "协议id")
    private String documentDetailId;
    @ApiModelProperty(value = "内容类型，0-文本，1-图片，2-视频，3-富文本")
    private String contentType;
}
