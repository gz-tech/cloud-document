package com.upuphone.cloudplatform.document.business.service.version;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.document.entity.DocumentVersionPo;
import com.upuphone.cloudplatform.document.mapper.DocumentVersionMapper;
import com.upuphone.cloudplatform.document.business.service.basic.util.VersionConvertUtil;
import com.upuphone.cloudplatform.document.vo.reponse.version.VersionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:05
 * @Version 1.0
 */
@Service
public class VersionListService extends BaseService<String, List<VersionVo>> {

    @Autowired
    private DocumentVersionMapper documentVersionMapper;

    @Override
    protected void validate(String s) {

    }

    @Override
    protected List<VersionVo> processCore(String s) throws Exception {
        List<DocumentVersionPo> documentVersionPoList = documentVersionMapper.selectList(Wrappers.<DocumentVersionPo>lambdaQuery()
                .eq(DocumentVersionPo::getDocumentId, s)
                .orderByDesc(DocumentVersionPo::getVersionId));
        List<VersionVo> documentVoList = documentVersionPoList.stream().map(DocumentVersionPo ->
                VersionConvertUtil.convertFromPo(DocumentVersionPo)).collect(Collectors.toList());
        return documentVoList;
    }
}
