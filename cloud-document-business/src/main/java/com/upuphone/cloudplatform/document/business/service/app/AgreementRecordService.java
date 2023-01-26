package com.upuphone.cloudplatform.document.business.service.app;

import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.document.entity.UserAgreementPo;
import com.upuphone.cloudplatform.document.mapper.UserAgreementMapper;
import com.upuphone.cloudplatform.document.vo.request.AgreementRecordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname AgreementRecordService
 * @Description 用户协议记录
 * @Date 2022/7/8 10:00 上午
 * @Created by gz-d
 */
@Service
public class AgreementRecordService extends BaseService<AgreementRecordRequest, Integer> {
    @Autowired
    private UserAgreementMapper userAgreementMapper;
    @Override
    protected void validate(AgreementRecordRequest request) {

    }

    @Override
    protected Integer processCore(AgreementRecordRequest request) throws Exception {
        UserAgreementPo userAgreement = new UserAgreementPo();
        userAgreement.setDocDetailId(Long.parseLong(request.getDocumentDetailId()));
        userAgreement.setUserId(Long.parseLong(request.getUserId()));
        userAgreement.setIsAgree(0);
        userAgreementMapper.insert(userAgreement);
        return 1;
    }
}
