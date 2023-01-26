package com.upuphone.cloudplatform.document.business.service.version;

import com.ctrip.framework.apollo.ConfigFile;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;
import com.upuphone.cloudplatform.common.component.BaseService;
import com.upuphone.cloudplatform.common.utils.JsonUtility;
import com.upuphone.cloudplatform.document.vo.reponse.version.LanguageVo;
import com.upuphone.cloudplatform.document.vo.request.version.LanguageResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname LanguageListService
 * @Description
 * @Date 2022/7/4 5:53 下午
 * @Created by gz-d
 */
@Service
public class LanguageListService extends BaseService<Void, LanguageResponse> {
    @Override
    protected void validate(Void unused) {

    }

    @Override
    protected LanguageResponse processCore(Void unused) throws Exception {
        ConfigFile configFile = ConfigService.getConfigFile("language", ConfigFileFormat.JSON);
        String content = configFile.getContent();
        List<LanguageVo> languageList = JsonUtility.toList(content, LanguageVo.class);
        Collections.sort(languageList, new Comparator<LanguageVo>() {
            @Override
            public int compare(LanguageVo o1, LanguageVo o2) {
                return o2.getCn().compareTo(o1.getCn());
            }
        });
        LanguageResponse response = new LanguageResponse();
        response.setLanguageList(languageList);
        return response;
    }
}
