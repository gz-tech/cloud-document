package com.upuphone.cloudplatform.document.controller;

import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.api.AppDocumentClient;
import com.upuphone.cloudplatform.document.business.service.app.AgreementRecordService;
import com.upuphone.cloudplatform.document.business.service.app.GetDocumentContentService;
import com.upuphone.cloudplatform.document.business.service.app.GetDocumentService;
import com.upuphone.cloudplatform.document.vo.request.AgreementRecordRequest;
import com.upuphone.cloudplatform.document.vo.request.DocumentRequest;
import com.upuphone.cloudplatform.document.vo.response.DocumentContentResponse;
import com.upuphone.cloudplatform.document.vo.response.DocumentResponse;
import com.upuphone.cloudplatform.internal.admin.starter.anno.DisableSso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Classname AppDocumentController
 * @Description
 * @Date 2022/6/23 3:29 下午
 * @Created by gz-d
 */
@RestController
public class AppDocumentController implements AppDocumentClient {
    @Autowired
    private GetDocumentService getDocumentService;
    @Autowired
    private GetDocumentContentService getDocumentContentService;
    @Autowired
    private AgreementRecordService agreementRecordService;

    @Override
    @DisableSso
    public CommonResponse<DocumentResponse> get(DocumentRequest request) {
        return CommonResponse.success(getDocumentService.process(request));
    }

    @Override
    @DisableSso
    public CommonResponse<DocumentContentResponse> getDocumentContent(String documentDetailId) {
        return CommonResponse.success(getDocumentContentService.process(documentDetailId));
    }

    @Override
    @DisableSso
    public CommonResponse agreementRecord(@Valid AgreementRecordRequest request) {
        agreementRecordService.process(request);
        return CommonResponse.success();
    }
}
