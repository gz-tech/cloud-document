package com.upuphone.cloudplatform.document.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.upuphone.cloudplatform.common.response.CommonResponse;
import com.upuphone.cloudplatform.document.vo.reponse.document.DocumentVo;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentAddRequest;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentEditRequest;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentListRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 18:58
 * @Version 1.0
 */
@Api(tags = "类型管理API")
public interface DocumentClient {
    @PostMapping("/document-manage/list")
    @ResponseBody
    @ApiOperation("类型列表")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse<PageDTO<DocumentVo>> list(@RequestBody @Valid DocumentListRequest request);

    @PostMapping("/document-manage/add")
    @ResponseBody
    @ApiOperation("新增类型")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse add(@RequestBody @Valid DocumentAddRequest request);

    @PostMapping("/document-manage/edit")
    @ResponseBody
    @ApiOperation("编辑类型")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "admin-access-token", value = "access_token", required = true)
    )
    CommonResponse edit(@RequestBody @Valid DocumentEditRequest request);
}