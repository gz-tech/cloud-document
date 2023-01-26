package com.upuphone.cloudplatform.document.vo.request.version;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname GetUploadUrlRequest
 * @Description TODO
 * @Date 2022/7/29 4:14 下午
 * @Created by gz-d
 */
@ApiModel(value = "获取上传链接")
@Getter
@Setter
public class GetUploadUrlRequest {
    @ApiModelProperty(value = "versionId", required = true)
    private String fileName;
    @ApiModelProperty(value = "versionId", required = true)
    private String fileType;
}
