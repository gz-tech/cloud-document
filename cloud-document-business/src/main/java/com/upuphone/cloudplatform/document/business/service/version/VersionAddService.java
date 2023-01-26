package com.upuphone.cloudplatform.document.business.service.version;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.context.RequestContext;
import com.upuphone.cloudplatform.document.business.service.mybatisplus.DocumentDetailService;
import com.upuphone.cloudplatform.document.common.util.OrikaUtil;
import com.upuphone.cloudplatform.document.entity.DocumentDetailPo;
import com.upuphone.cloudplatform.document.entity.DocumentVersionPo;
import com.upuphone.cloudplatform.document.mapper.DocumentVersionMapper;
import com.upuphone.cloudplatform.document.vo.request.version.VersionAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:05
 * @Version 1.0
 */
@Service
public class VersionAddService extends BaseService<VersionAddRequest, Integer> {

    @Autowired
    private DocumentVersionMapper documentVersionMapper;
    @Autowired
    private DocumentDetailService documentDetailService;

    @Override
    protected void validate(VersionAddRequest versionAddRequest) {

    }

    /**
     * 当document_detail新增一个版本时，需要同时在 document_version 里添加数据
     */
    @Transactional(rollbackFor = Exception.class, timeout = 5)
    @Override
    protected Integer processCore(VersionAddRequest versionAddRequest) throws Exception {
        String operator = RequestContext.getOperator();
        //版本号从100开始新增
        DocumentVersionPo insertDocumentVersion = new DocumentVersionPo();
        DocumentVersionPo maxDocumentVersion = documentVersionMapper.selectOne(new QueryWrapper<DocumentVersionPo>()
                .eq("document_id", versionAddRequest.getDocumentId())
                .orderByDesc("version_id")
                .last("limit 1"));
        if (maxDocumentVersion == null) {
            insertDocumentVersion.setVersionId("100");
        } else {
            insertDocumentVersion.setVersionId((Integer.parseInt(maxDocumentVersion.getVersionId()) + 1) + "");
        }
        insertDocumentVersion.setDocumentId(Long.parseLong(versionAddRequest.getDocumentId()));
        insertDocumentVersion.setCreateBy(operator);
        insertDocumentVersion.setUpdateBy(operator);
        documentVersionMapper.insert(insertDocumentVersion);

        List<DocumentDetailPo> documentList = OrikaUtil.mapAsList(versionAddRequest.getDocumentList(), DocumentDetailPo.class);
        documentList.stream().forEach(documentDetailPo -> {
            documentDetailPo.setUpdateBy(operator);
            documentDetailPo.setCreateBy(operator);
            documentDetailPo.setDocumentVersion(insertDocumentVersion.getId());
        });
        documentDetailService.saveBatch(documentList);
        return 1;
    }
}
