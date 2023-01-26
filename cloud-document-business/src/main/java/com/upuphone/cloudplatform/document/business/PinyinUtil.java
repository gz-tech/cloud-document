package com.upuphone.cloudplatform.document.business;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @Classname PinyinUtil
 * @Description TODO
 * @Date 2022/7/29 5:44 下午
 * @Created by gz-d
 */
public class PinyinUtil {
    private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

    static {
        // 拼音小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 不带声调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // u 用 v 代替
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
    }
    /**
     * 比较两个字符串大小
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int compare(String s1, String s2) throws BadHanyuPinyinOutputFormatCombination {
        for (int i = 0, len = Math.min(s1.length(), s2.length()); i < len; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            // 两个字符相等，继续往后比较
            if (c1 == c2) continue;
            // c1 和 c2 都是中文字符，将其转换为拼音再用 compareTo 比较 ASCII 码
            if ((c1 + "").matches("[\\u4E00-\\u9FA5]+") && (c2 + "").matches("[\\u4E00-\\u9FA5]+"))
                return PinyinHelper.toHanyuPinyinStringArray(c1, format)[0].compareTo(PinyinHelper.toHanyuPinyinStringArray(c2, format)[0]);
            // 直接比较 CodePoint
            return c1 - c2;
        }
        return s1.length() - s2.length();
    }

}
