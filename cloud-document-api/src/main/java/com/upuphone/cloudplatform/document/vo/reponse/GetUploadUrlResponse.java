package com.upuphone.cloudplatform.document.vo.reponse;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname GetUploadUrlReponse
 * @Description TODO
 * @Date 2022/7/29 4:18 下午
 * @Created by gz-d
 */
@Getter
@Setter
@ApiModel(value = "上传url")
public class GetUploadUrlResponse {
    private String url;
}
