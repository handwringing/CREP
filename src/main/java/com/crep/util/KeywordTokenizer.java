package com.crep.util;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import java.util.List;
import java.util.stream.Collectors;

public class KeywordTokenizer {

    /**
     * 对给定的文本进行分词处理。
     *
     * @param text 待分词的连续字符串文本。
     * @return 分词后的关键词列表。
     */
    public static List<String> tokenize(String text) {
        List<Term> termList = HanLP.segment(text);
        List<String> keywords = termList.stream()
                .map(term -> term.word)
                .collect(Collectors.toList());
        return keywords;
    }
}