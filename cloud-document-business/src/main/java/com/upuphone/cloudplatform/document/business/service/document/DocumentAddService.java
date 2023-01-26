package com.upuphone.cloudplatform.document.business.service.document;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.context.RequestContext;
import com.upuphone.cloudplatform.common.exception.BusinessException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.document.entity.DocumentPo;
import com.upuphone.cloudplatform.document.errorcode.DocumentErrorCode;
import com.upuphone.cloudplatform.document.mapper.DocumentMapper;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:01
 * @Version 1.0
 */
@Service
public class DocumentAddService extends BaseService<DocumentAddRequest, Integer> {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    protected void validate(DocumentAddRequest request) {

    }

    @Override
    protected Integer processCore(DocumentAddRequest request) throws Exception {
        String operator = RequestContext.getOperator();
        DocumentPo documentPo = new DocumentPo();
        QueryWrapper<DocumentPo> query = new QueryWrapper<>();
        query.select("id");
        Long num = documentMapper.selectCount(query);
        DecimalFormat df1 = new DecimalFormat("0000000");
        String addNum = df1.format(num+1);
        documentPo.setTypeId(addNum);
        documentPo.setUpdateBy(operator);
        documentPo.setName(request.getName());
        try {
            documentMapper.insert(documentPo);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(DocumentErrorCode.DUPLICATE_NAME_ERROR);
        } catch (Exception e) {
            throw new BusinessException(CommonErrorCode.SERVICE_ERROR);
        }
        return 1;
    }
}