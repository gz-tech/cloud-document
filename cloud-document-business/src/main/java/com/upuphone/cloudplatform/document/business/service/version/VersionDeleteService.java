package com.upuphone.cloudplatform.document.business.service.version;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.exception.BusinessException;
import com.upuphone.cloudplatform.common.response.CommonErrorCode;
import com.upuphone.cloudplatform.document.entity.DocumentDetailPo;
import com.upuphone.cloudplatform.document.entity.DocumentVersionPo;
import com.upuphone.cloudplatform.document.mapper.DocumentDetailMapper;
import com.upuphone.cloudplatform.document.mapper.DocumentVersionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Min.Jiang
 * @Date 2022/6/22 19:05
 * @Version 1.0
 */
@Service
@Slf4j
public class VersionDeleteService extends BaseService<String, Integer> {

    @Autowired
    private DocumentVersionMapper documentVersionMapper;

    @Autowired
    private DocumentDetailMapper documentDetailMapper;

    @Override
    protected void validate(String s) {

    }

    /**
     * 当document_detail删除一个版本时，需要同时在document_version里删除相应数据
     */
    @Transactional(rollbackFor = Exception.class, timeout = 10)
    @Override
    protected Integer processCore(String id) throws Exception {
        try {
            documentVersionMapper.deleteById(id);
            documentDetailMapper.delete(Wrappers.<DocumentDetailPo>lambdaQuery().eq(DocumentDetailPo::getDocumentVersion, id));
        } catch (Exception e) {
            log.error("删除失败");
            throw new BusinessException(CommonErrorCode.SERVICE_ERROR);
        }
        return 1;
    }
}
