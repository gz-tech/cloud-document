package com.upuphone.cloudplatform.document.business.service.basic.util;

import com.upuphone.cloudplatform.common.exception.ServiceException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.document.entity.DocumentVersionPo;
import com.upuphone.cloudplatform.document.vo.reponse.version.VersionVo;

/**
 * @Author Min.Jiang
 * @Date 2022/6/23 20:05
 * @Version 1.0
 */
public class VersionConvertUtil {
    public static VersionVo convertFromPo(DocumentVersionPo documentPo) {
        if (documentPo == null) {
            throw new ServiceException(CommonErrorCode.PARAM_ERROR);
        }
        VersionVo versionVo = new VersionVo();
        versionVo.setId(documentPo.getId().toString());
        versionVo.setVersionId(documentPo.getVersionId());
        versionVo.setUpdateBy(documentPo.getUpdateBy());
        versionVo.setUpdateTime(documentPo.getUpdateTime());
        return versionVo;
    }
}
