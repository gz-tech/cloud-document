package com.upuphone.cloudplatform.document.business.service.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.upuphone.cloudplatform.document.entity.DocumentVersionPo;
import com.upuphone.cloudplatform.document.mapper.DocumentVersionMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guangzheng.ding
 * @since 2022-06-23
 */
@Service
public class DocumentVersionServiceImpl extends ServiceImpl<DocumentVersionMapper, DocumentVersionPo> implements DocumentVersionService {

}
