package com.upuphone.cloudplatform.document.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.api.DocumentClient;
import com.upuphone.cloudplatform.document.business.service.document.DocumentAddService;
import com.upuphone.cloudplatform.document.business.service.document.DocumentEditService;
import com.upuphone.cloudplatform.document.business.service.document.DocumentListService;
import com.upuphone.cloudplatform.document.vo.reponse.document.DocumentVo;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentAddRequest;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentEditRequest;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Classname DocumentManagementController
 * @Description
 * @Date 2022/3/23 5:48 下午
 * @Created by gz-d
 */
@RestController
public class DocumentController implements DocumentClient {
    @Autowired
    private DocumentListService documentListService;

    @Autowired
    private DocumentAddService documentAddService;

    @Autowired
    private DocumentEditService documentEditService;

    @Override
    public CommonResponse<PageDTO<DocumentVo>> list(@Valid DocumentListRequest request) {
        return CommonResponse.success(documentListService.process(request));
    }

    @Override
    public CommonResponse add(@Valid DocumentAddRequest request) {
        documentAddService.process(request);
        return CommonResponse.success();
    }

    @Override
    public CommonResponse edit(@Valid DocumentEditRequest request) {
        documentEditService.process(request);
        return CommonResponse.success();
    }

}
