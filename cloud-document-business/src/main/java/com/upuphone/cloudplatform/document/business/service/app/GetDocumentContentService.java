package com.upuphone.cloudplatform.document.business.service.app;

import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.document.entity.DocumentDetailPo;
import com.upuphone.cloudplatform.document.mapper.DocumentDetailMapper;
import com.upuphone.cloudplatform.document.vo.response.DocumentContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname GetDocumentContentService
 * @Description TODO
 * @Date 2022/6/30 10:00 上午
 * @Created by gz-d
 */
@Service
public class GetDocumentContentService extends BaseService<String, DocumentContentResponse> {
    @Autowired
    private DocumentDetailMapper documentDetailMapper;
    @Override
    protected void validate(String s) {

    }
    @Override
    protected DocumentContentResponse processCore(String s) throws Exception {
        DocumentDetailPo documentDetailPo = documentDetailMapper.selectById(s);
        DocumentContentResponse response = new DocumentContentResponse();
        response.setContent(documentDetailPo.getContent());
        response.setContentType(documentDetailPo.getContentType().toString());
        return response;
    }
}
