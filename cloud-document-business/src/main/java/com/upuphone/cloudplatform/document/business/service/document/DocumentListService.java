package com.upuphone.cloudplatform.document.business.service.document;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.document.entity.DocumentPo;
import com.upuphone.cloudplatform.document.mapper.DocumentMapper;
import com.upuphone.cloudplatform.document.business.service.basic.util.DocumentConvertUtil;
import com.upuphone.cloudplatform.document.vo.reponse.document.DocumentVo;
import com.upuphone.cloudplatform.document.vo.request.document.DocumentListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:01
 * @Version 1.0
 */
@Service
public class DocumentListService extends BaseService<DocumentListRequest, PageDTO<DocumentVo>> {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    protected void validate(DocumentListRequest request) {

    }

    @Override
    protected PageDTO<DocumentVo> processCore(DocumentListRequest request) throws Exception {
        QueryWrapper<DocumentPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(request.getName()), "name", request.getName());
        queryWrapper.like(StringUtils.isNotEmpty(request.getTypeId()), "type_id", request.getTypeId());
        queryWrapper.orderByDesc("type_id");
        IPage<DocumentPo> documentPage = documentMapper.selectPage(new Page<>(request.getPageNum(), request.getPageSize()), queryWrapper);
        List<DocumentVo> documentVoList = documentPage.getRecords().stream().map(DocumentPo ->
                DocumentConvertUtil.convertFromPo(DocumentPo)).collect(Collectors.toList());
        PageDTO<DocumentVo> pageDTO = new PageDTO<>(
                documentPage.getCurrent(),
                documentPage.getSize(),
                documentPage.getTotal()
        );
        pageDTO.setRecords(documentVoList);
        return pageDTO;
    }
}