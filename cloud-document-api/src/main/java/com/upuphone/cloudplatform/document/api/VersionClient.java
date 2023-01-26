package com.upuphone.cloudplatform.document.api;

import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.vo.reponse.GetUploadUrlResponse;
import com.upuphone.cloudplatform.document.vo.reponse.UpLoadPhotoResponse;
import com.upuphone.cloudplatform.document.vo.reponse.VersionDetailResponse;
import com.upuphone.cloudplatform.document.vo.reponse.version.VersionVo;
import com.upuphone.cloudplatform.document.vo.request.version.DocumentDetailEditRequest;
import com.upuphone.cloudplatform.document.vo.request.version.GetUploadUrlRequest;
import com.upuphone.cloudplatform.document.vo.request.version.LanguageResponse;
import com.upuphone.cloudplatform.document.vo.request.version.VersionAddRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author Min.Jiang
 * @Date 2022/6/23 19:45
 * @Version 1.0
 */
@Api(tags = "版本管理API")
public interface VersionClient {
    @GetMapping("/version-manage/list")
    @ResponseBody
    @ApiOperation("版本列表")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse<List<VersionVo>> list(@RequestParam("id")@ApiParam(value = "文案类型id", required = true) String id);

    @PostMapping("/version-manage/add")
    @ResponseBody
    @ApiOperation("新增文案")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse add(@RequestBody @Valid VersionAddRequest request);

    @GetMapping("/version-manage/detail/{id}")
    @ApiOperation("版本详情")
    CommonResponse<VersionDetailResponse> versionDetail(@PathVariable("id") String versionId);

    @PostMapping("/version-manage/edit")
    @ResponseBody
    @ApiOperation("编辑文案")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse edit(@RequestBody @Valid DocumentDetailEditRequest request);

    @DeleteMapping("/version-manage/delete/{id}")
    @ResponseBody
    @ApiOperation("删除版本")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse delete(@PathVariable @ApiParam(name = "id", value = "版本主键id") String id);

    @GetMapping("/document-detail/language")
    @ApiOperation("语言选择下拉列表")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse<LanguageResponse> getLanguageList();

    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    @PostMapping(value = "/upload-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "上传图片")
    CommonResponse<UpLoadPhotoResponse> uploadPhoto(@RequestPart("file") MultipartFile multipartFile);

    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    @PostMapping(value = "/get-upload-url")
    @ApiOperation(value = "获取上传url")
    CommonResponse<GetUploadUrlResponse> getUploadUrl(@RequestBody GetUploadUrlRequest request);
}
