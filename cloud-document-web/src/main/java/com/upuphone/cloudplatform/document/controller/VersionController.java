package com.upuphone.cloudplatform.document.controller;

import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.api.VersionClient;
import com.upuphone.cloudplatform.document.business.service.remote.storage.GetUploadUrlRemoteService;
import com.upuphone.cloudplatform.document.business.service.version.DocumentDetailEditService;
import com.upuphone.cloudplatform.document.business.service.version.GetUploadUrlService;
import com.upuphone.cloudplatform.document.business.service.version.LanguageListService;
import com.upuphone.cloudplatform.document.business.service.version.UploadPhotoService;
import com.upuphone.cloudplatform.document.business.service.version.VersionAddService;
import com.upuphone.cloudplatform.document.business.service.version.VersionDeleteService;
import com.upuphone.cloudplatform.document.business.service.version.VersionDetailService;
import com.upuphone.cloudplatform.document.business.service.version.VersionListService;
import com.upuphone.cloudplatform.document.vo.reponse.GetUploadUrlResponse;
import com.upuphone.cloudplatform.document.vo.reponse.UpLoadPhotoResponse;
import com.upuphone.cloudplatform.document.vo.reponse.VersionDetailResponse;
import com.upuphone.cloudplatform.document.vo.reponse.version.VersionVo;
import com.upuphone.cloudplatform.document.vo.request.version.DocumentDetailEditRequest;
import com.upuphone.cloudplatform.document.vo.request.version.GetUploadUrlRequest;
import com.upuphone.cloudplatform.document.vo.request.version.LanguageResponse;
import com.upuphone.cloudplatform.document.vo.request.version.VersionAddRequest;
import com.upuphone.cloudplatform.internal.admin.starter.anno.DisableSso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:05
 * @Version 1.0
 */
@RestController
public class VersionController implements VersionClient {
    @Autowired
    private VersionListService versionListService;

    @Autowired
    private VersionAddService versionAddService;

    @Autowired
    private DocumentDetailEditService documentDetailEditService;

    @Autowired
    private VersionDeleteService versionDeleteService;

    @Autowired
    private LanguageListService languageListService;
    @Autowired
    private UploadPhotoService uploadPhotoService;
    @Autowired
    private VersionDetailService versionDetailService;
    @Autowired
    private GetUploadUrlService getUploadUrlService;

    @Override
    public CommonResponse<List<VersionVo>> list(@Valid String id) {
        return CommonResponse.success(versionListService.process(id));
    }

    @Override
    public CommonResponse add(@Valid VersionAddRequest request) {
        versionAddService.process(request);
        return CommonResponse.success();
    }

    @Override
    public CommonResponse<VersionDetailResponse> versionDetail(String versionId) {
        return CommonResponse.success(versionDetailService.process(versionId));
    }

    @Override
    @DisableSso
    public CommonResponse edit(@Valid DocumentDetailEditRequest request) {
        documentDetailEditService.process(request);
        return CommonResponse.success();
    }

    @Override
    public CommonResponse delete(String id) {
        versionDeleteService.process(id);
        return CommonResponse.success();
    }

    @Override
    @DisableSso
    public CommonResponse<LanguageResponse> getLanguageList() {
        return CommonResponse.success(languageListService.process(null));
    }

    @Override
    @DisableSso
    public CommonResponse<UpLoadPhotoResponse> uploadPhoto(MultipartFile multipartFile) {
        return CommonResponse.success(uploadPhotoService.process(multipartFile));
    }

    @Override
    @DisableSso
    public CommonResponse<GetUploadUrlResponse> getUploadUrl(GetUploadUrlRequest request) {
        return CommonResponse.success(getUploadUrlService.process(request));
    }
}
