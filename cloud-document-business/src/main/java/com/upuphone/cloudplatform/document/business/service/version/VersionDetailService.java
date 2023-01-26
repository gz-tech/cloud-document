package com.upuphone.cloudplatform.document.business.service.version;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.document.business.PinyinUtil;
import com.upuphone.cloudplatform.document.common.util.OrikaUtil;
import com.upuphone.cloudplatform.document.entity.DocumentDetailPo;
import com.upuphone.cloudplatform.document.mapper.DocumentDetailMapper;
import com.upuphone.cloudplatform.document.vo.reponse.VersionDetailResponse;
import com.upuphone.cloudplatform.document.vo.reponse.version.DocumentDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname VersionDetailService
 * @Description 版本包含的各语种文案/协议
 * @Date 2022/7/8 4:48 下午
 * @Created by gz-d
 */
@Service
public class VersionDetailService extends BaseService<String, VersionDetailResponse> {
    @Autowired
    private DocumentDetailMapper documentDetailMapper;



    @Override
    protected void validate(String versionId) {

    }

    @Override
    protected VersionDetailResponse processCore(String versionId) throws Exception {
        List<DocumentDetailPo> documentDetailList = documentDetailMapper.selectList(Wrappers.<DocumentDetailPo>lambdaQuery()
                .eq(DocumentDetailPo::getDocumentVersion, versionId));
        List<DocumentDetailVo> documentDetailVoList = OrikaUtil.mapAsList(documentDetailList, DocumentDetailVo.class);
        VersionDetailResponse response = new VersionDetailResponse();
        response.setDocumentDetailList(documentDetailVoList);
        return response;
    }
}
