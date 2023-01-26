package com.upuphone.cloudplatform.document.business.service.remote.storage;

import com.upuphone.cloudplatform.common.component.BaseRemoteService;
import com.upuphone.cloudplatform.common.exception.RemoteException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.business.setting.Setting;
import com.upuphone.cloudplatform.storage.api.StorageServiceApi;
import com.upuphone.cloudplatform.storage.api.dto.storage.response.StorageInfoUrlRspDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 */
@Component("fileUploadRemoteService")
public class FileUploadRemoteService extends BaseRemoteService<MultipartFile, StorageInfoUrlRspDTO, CommonResponse<StorageInfoUrlRspDTO>> {
    @Autowired
    private StorageServiceApi storageServiceApi;
    @Autowired
    private Setting setting;

    public FileUploadRemoteService(@Value("cloud-storage-web") String service, @Value("createObject") String apiName) {
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
    protected CommonResponse<StorageInfoUrlRspDTO> processCore(MultipartFile file) throws Exception {

        return storageServiceApi.createObject(file,
                setting.getFileUploadToken(), 1L, file.getOriginalFilename(), "", 1);
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
