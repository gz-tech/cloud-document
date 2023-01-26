package com.upuphone.cloudplatform.document.api;

import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.vo.request.AgreementRecordRequest;
import com.upuphone.cloudplatform.document.vo.request.DocumentRequest;
import com.upuphone.cloudplatform.document.vo.response.DocumentContentResponse;
import com.upuphone.cloudplatform.document.vo.response.DocumentResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @Classname AppDocumentClient
 * @Description 客户端获取
 * @Date 2022/6/23 1:48 下午
 * @Created by gz-d
 */
@Api(tags = "客户端 API")
@FeignClient(name = "cloud-document", contextId = "app-client")
public interface AppDocumentClient {
    @GetMapping("/document/get")
    @ApiOperation(value = "app获取文案")
    CommonResponse<DocumentResponse> get(@Valid DocumentRequest request);

    @ApiOperation("获取协议content")
    @GetMapping("/document/detail/{id}")
    CommonResponse<DocumentContentResponse> getDocumentContent(@PathVariable("id")String documentDetailId);

    @ApiOperation("用户协议记录")
    @PostMapping("/agreement/record")
    CommonResponse agreementRecord(@RequestBody @Valid AgreementRecordRequest request);

}
