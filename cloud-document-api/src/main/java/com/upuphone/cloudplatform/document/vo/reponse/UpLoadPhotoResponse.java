package com.upuphone.cloudplatform.document.vo.reponse;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 照片上传response
 */
@Getter
@Setter
@ApiModel(value = "上传照片 response")
public class UpLoadPhotoResponse {
    private String fileId;
    private String url;
}
