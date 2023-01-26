package com.upuphone.cloudplatform.document.business.service.basic.util;

import com.upuphone.cloudplatform.common.exception.ServiceException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.document.entity.DocumentPo;
import com.upuphone.cloudplatform.document.vo.reponse.document.DocumentVo;

/**
 * @Author Min.Jiang
 * @Date 2022/6/23 20:05
 * @Version 1.0
 */
public class DocumentConvertUtil {

    public static DocumentVo convertFromPo(DocumentPo documentPo) {
        if (documentPo == null) {
            throw new ServiceException(CommonErrorCode.PARAM_ERROR);
        }
        DocumentVo documentVo = new DocumentVo();
        documentVo.setId(documentPo.getId() + "");
        documentVo.setName(documentPo.getName());
        documentVo.setTypeId(documentPo.getTypeId());
        return documentVo;
    }
}
