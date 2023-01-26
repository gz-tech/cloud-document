package com.upuphone.cloudplatform.document.business.service.remote.storage;

import com.upuphone.cloudplatform.common.component.BaseRemoteService;
import com.upuphone.cloudplatform.common.exception.RemoteException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.business.setting.Setting;
import com.upuphone.cloudplatform.document.vo.request.version.GetUploadUrlRequest;
import com.upuphone.cloudplatform.storage.api.StorageServiceApi;
import com.upuphone.cloudplatform.storage.api.dto.storage.StorageInfoUrlReqDTO;
import com.upuphone.cloudplatform.storage.api.dto.storage.response.StorageInfoUrlRspDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 */
@Component("getUploadUrlRemoteService")
public class GetUploadUrlRemoteService extends BaseRemoteService<GetUploadUrlRequest, StorageInfoUrlRspDTO, CommonResponse<StorageInfoUrlRspDTO>> {
    @Autowired
    private StorageServiceApi storageServiceApi;
    @Autowired
    private Setting setting;

    public GetUploadUrlRemoteService(@Value("cloud-storage-web") String service, @Value("createObject") String apiName) {
        super(service, apiName);
    }

    @Override
    protected StorageInfoUrlRspDTO fromRemoteResponse(CommonResponse<StorageInfoUrlRspDTO> response) {
        if (response == null
                || response.getCode() != 0 || response.getData() == null) {
            throw new RemoteException(CommonErrorCode.REMOTE_ERROR);
        }
        return response.getData();
    }

    @Override
    protected CommonResponse<StorageInfoUrlRspDTO> processCore(GetUploadUrlRequest request) throws Exception {
        StorageInfoUrlReqDTO storageInfoUrlReqDTO = new StorageInfoUrlReqDTO();
        storageInfoUrlReqDTO.setFileName(request.getFileName());
        storageInfoUrlReqDTO.setIsPublic(1);
        storageInfoUrlReqDTO.setFileType(request.getFileType());
        return storageServiceApi.getPutObjectUrl(storageInfoUrlReqDTO);
    }

    @Override
    protected String getServiceName() {
        return "cloud-storage-web";
    }

    @Override
    protected String getApiName() {
        return "createObject";
    }

    @Override
    protected boolean enableRequestLog() {
        return false;
    }

    @Override
    protected boolean enableResponseLog() {
        return true;
    }
}
