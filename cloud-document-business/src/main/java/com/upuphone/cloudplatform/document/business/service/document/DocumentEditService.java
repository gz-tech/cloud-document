package com.upuphone.cloudplatform.document.business.service.document;

import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.context.RequestContext;
import com.upuphone.cloudplatform.common.exception.BusinessException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.document.entity.DocumentPo;
import com.upuphone.cloudplatform.document.errorcode.DocumentErrorCode;
import com.upuphone.cloudplatform.document.mapper.DocumentMapper;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentEditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:01
 * @Version 1.0
 */
@Service
public class DocumentEditService extends BaseService<DocumentEditRequest, Integer> {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    protected void validate(DocumentEditRequest request) {

    }

    @Override
    protected Integer processCore(DocumentEditRequest request) throws Exception {
        String operator = RequestContext.getOperator();
        DocumentPo documentPo = new DocumentPo();
        documentPo.setUpdateBy(operator);
        documentPo.setId(request.getId());
        documentPo.setName(request.getName());
        try {
            documentMapper.updateById(documentPo);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(DocumentErrorCode.DUPLICATE_NAME_ERROR);
        } catch (Exception e) {
            throw new BusinessException(CommonErrorCode.SERVICE_ERROR);
        }
        return 1;
    }
}