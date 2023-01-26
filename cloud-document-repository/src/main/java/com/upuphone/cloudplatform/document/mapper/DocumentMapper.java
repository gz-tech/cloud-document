package com.upuphone.cloudplatform.document.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.upuphone.cloudplatform.document.entity.DocumentPo;
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
public interface DocumentMapper extends BaseMapper<DocumentPo> {
    List<DocumentPo> selectByTypeAndName(@Param("typeId")String typeId,
                                         @Param("name") String name);

}
