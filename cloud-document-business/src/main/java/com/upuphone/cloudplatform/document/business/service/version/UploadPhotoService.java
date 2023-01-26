package com.upuphone.cloudplatform.document.business.service.version;

import com.google.common.base.Strings;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.context.RequestContext;
import com.upuphone.cloudplatform.common.exception.BusinessException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.document.business.service.remote.storage.FileUploadRemoteService;
import com.upuphone.cloudplatform.document.vo.reponse.UpLoadPhotoResponse;
import com.upuphone.cloudplatform.storage.api.dto.storage.response.StorageInfoUrlRspDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 */
@Service
@Slf4j
public class UploadPhotoService extends BaseService<MultipartFile, UpLoadPhotoResponse> {
    @Autowired
    private FileUploadRemoteService fileUploadRetryRemoteService;
    @Override
    protected void validate(MultipartFile request) {
    }

    @Override
    protected UpLoadPhotoResponse processCore(MultipartFile soaRequest) throws Exception {

        StorageInfoUrlRspDTO storageResult = fileUploadRetryRemoteService.process(soaRequest);
        UpLoadPhotoResponse response = new UpLoadPhotoResponse();
        response.setFileId(storageResult.getFileId());
        response.setUrl(storageResult.getUrl());
        return response;
    }
}
