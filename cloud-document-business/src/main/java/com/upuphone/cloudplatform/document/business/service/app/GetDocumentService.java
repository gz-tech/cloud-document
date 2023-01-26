package com.upuphone.cloudplatform.document.business.service.app;

import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.exception.BusinessException;
import com.upuphone.cloudplatform.document.business.setting.Setting;
import com.upuphone.cloudplatform.document.entity.DocumentDetailPo;
import com.upuphone.cloudplatform.document.errorcode.DocumentErrorCode;
import com.upuphone.cloudplatform.document.mapper.DocumentDetailMapper;
import com.upuphone.cloudplatform.document.vo.request.DocumentRequest;
import com.upuphone.cloudplatform.document.vo.response.DocumentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @Classname GetDocumentService
 * @Description
 * @Date 2022/6/23 3:58 下午
 * @Created by gz-d
 */
@Service
public class GetDocumentService extends BaseService<DocumentRequest, DocumentResponse> {
    @Autowired
    private DocumentDetailMapper documentDetailMapper;
    @Autowired
    private Setting setting;

    @Override
    protected void validate(DocumentRequest documentRequest) {

    }

    @Override
    protected DocumentResponse processCore(DocumentRequest request) throws Exception {
        List<DocumentDetailPo> documentList = documentDetailMapper.selectDocuments(request.getLanguage(), request.getDocumentId(), request.getTargetVersionId());
        if (ObjectUtils.isEmpty(documentList)) {
            throw new BusinessException(DocumentErrorCode.NOT_EXIST_ERROR);
        }
        Collections.sort(documentList, new Comparator<DocumentDetailPo>() {
            @Override
            public int compare(DocumentDetailPo o1, DocumentDetailPo o2) {
                return (int) (o1.getDocumentVersion() - o2.getDocumentVersion());
            }
        });
        DocumentDetailPo targetDocument = null;
        targetDocument = documentList.get(0);
        DocumentResponse response = new DocumentResponse();
        response.setVersionId(targetDocument.getVersionId());
        response.setDocumentDetailId(targetDocument.getId().toString());
        response.setContentType(targetDocument.getContentType().toString());
        if (Objects.equals(request.getType(), "h5")) {
            StringBuilder s = new StringBuilder();
            s.append(setting.getDocumentH5()).append("?id=").append(targetDocument.getId().toString());
            response.setHtmlPlainText(s.toString());
        } else {
            response.setText(targetDocument.getContent());
        }
        return response;
    }
}
