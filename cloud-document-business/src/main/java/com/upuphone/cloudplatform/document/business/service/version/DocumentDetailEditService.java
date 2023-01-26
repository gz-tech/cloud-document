package com.upuphone.cloudplatform.document.business.service.version;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.context.RequestContext;
import com.upuphone.cloudplatform.document.business.service.mybatisplus.DocumentDetailService;
import com.upuphone.cloudplatform.document.entity.DocumentDetailPo;
import com.upuphone.cloudplatform.document.mapper.DocumentDetailMapper;
import com.upuphone.cloudplatform.document.mapper.DocumentVersionMapper;
import com.upuphone.cloudplatform.document.vo.request.version.DocumentDetailEditRequest;
import com.upuphone.cloudplatform.document.vo.request.version.DocumentDetailEditVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:05
 * @Version 1.0
 */
@Service
public class DocumentDetailEditService extends BaseService<DocumentDetailEditRequest, Integer> {
    @Autowired
    private DocumentDetailService documentDetailService;
    @Autowired
    private DocumentDetailMapper documentDetailMapper;

    @Override
    protected void validate(DocumentDetailEditRequest documentDetailEditRequest) {

    }

    @Override
    protected Integer processCore(DocumentDetailEditRequest documentDetailEditRequest) throws Exception {
        List<DocumentDetailPo> addList = new ArrayList<>();
        List<DocumentDetailPo> updateList = new ArrayList<>();
        List<DocumentDetailPo> documentDetailPos = documentDetailMapper.selectList(Wrappers.<DocumentDetailPo>lambdaQuery()
                .eq(DocumentDetailPo::getDocumentVersion, documentDetailEditRequest.getVersionId()));
        List<String> existDetailIds = documentDetailPos.stream().map(DocumentDetailPo::getId).map(String::valueOf).collect(Collectors.toList());
        List<String> inputDetailIds = documentDetailEditRequest.getDocumentDetailList().stream().map(DocumentDetailEditVo::getId).collect(Collectors.toList());
        List<String> deleteDetailIds = existDetailIds.stream().filter(item -> !inputDetailIds.contains(item)).collect(Collectors.toList());
        List<Long> ids = deleteDetailIds.stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(ids)) {
            documentDetailMapper.deleteBatchIds(ids);
        }
        for (DocumentDetailEditVo vo
                : documentDetailEditRequest.getDocumentDetailList()) {
            if (Strings.isEmpty(vo.getId())) {
                DocumentDetailPo insertDocument = new DocumentDetailPo();
                insertDocument.setDocumentVersion(Long.parseLong(documentDetailEditRequest.getVersionId()));
                insertDocument.setContentType(Integer.parseInt(vo.getContentType()));
                insertDocument.setContent(vo.getContent());
                insertDocument.setLanguage(vo.getLanguage());
                insertDocument.setUpdateBy(RequestContext.getOperator());
                insertDocument.setCreateBy(RequestContext.getOperator());
                addList.add(insertDocument);
            } else {
                DocumentDetailPo updateDocument = new DocumentDetailPo();
                updateDocument.setId(Long.parseLong(vo.getId()));
                updateDocument.setContent(vo.getContent());
                updateDocument.setContentType(Integer.parseInt(vo.getContentType()));
                updateDocument.setLanguage(vo.getLanguage());
                updateDocument.setUpdateBy(RequestContext.getOperator());
                updateDocument.setUpdateTime(LocalDateTime.now());
                updateList.add(updateDocument);
            }
        }
        documentDetailService.saveBatch(addList);
        documentDetailService.updateBatchById(updateList);
        return 1;
    }
}
