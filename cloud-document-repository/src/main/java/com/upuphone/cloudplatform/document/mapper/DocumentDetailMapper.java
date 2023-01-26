package com.upuphone.cloudplatform.document.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.upuphone.cloudplatform.document.entity.DocumentDetailPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guangzheng.ding
 * @since 2022-06-23
 */
@Mapper
public interface DocumentDetailMapper extends BaseMapper<DocumentDetailPo> {
    List<DocumentDetailPo> selectDocuments(@Param("language") String language, @Param("documentId") String documentId, @Param("versionId") String versionId);
}
