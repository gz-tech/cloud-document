package com.upuphone.cloudplatform.document.business.service.version;

import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.document.business.service.remote.storage.GetUploadUrlRemoteService;
import com.upuphone.cloudplatform.document.vo.reponse.GetUploadUrlResponse;
import com.upuphone.cloudplatform.document.vo.request.version.GetUploadUrlRequest;
import com.upuphone.cloudplatform.storage.api.dto.storage.response.StorageInfoUrlRspDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname GetUploadUrlService
 * @Description TODO
 * @Date 2022/7/29 4:17 下午
 * @Created by gz-d
 */
@Service
public class GetUploadUrlService extends BaseService<GetUploadUrlRequest, GetUploadUrlResponse> {
    @Autowired
    private GetUploadUrlRemoteService getUploadUrlRemoteService;
    @Override
    protected void validate(GetUploadUrlRequest request) {

    }

    @Override
    protected GetUploadUrlResponse processCore(GetUploadUrlRequest request) throws Exception {
        StorageInfoUrlRspDTO storageInfoUrlRspDTO = getUploadUrlRemoteService.process(request);
        GetUploadUrlResponse response = new GetUploadUrlResponse();
        response.setUrl(storageInfoUrlRspDTO.getUrl());
        return response;
    }
}
