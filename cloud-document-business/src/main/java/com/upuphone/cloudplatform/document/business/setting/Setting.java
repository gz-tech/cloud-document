package com.upuphone.cloudplatform.document.business.setting;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname AppSetting
 * @Description
 * @Date 2022/6/23 5:23 下午
 * @Created by gz-d
 */
@Component
@Getter
@Setter
public class Setting {
    @Value("${document.h5.template:www.luna.com}")
    private String documentH5;
    @Value("${file.upload.token:a2ef406e2c2351e0b9e80029c909242d}")
    private String fileUploadToken;

}
