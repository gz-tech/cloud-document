package com.upuphone.cloudplatform.document.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname DocumentContentResponse
 * @Description
 * @Date 2022/7/13 4:13 下午
 * @Created by gz-d
 */
@ApiModel(value = "文案内容response")
@Getter
@Setter
public class DocumentContentResponse {
    private String contentType;

    private String content;
}
