package com.crep.service.impl;

import com.crep.entity.Item;
import com.crep.mapper.ItemMapper;
import com.crep.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public Item getItemById(Integer itemId) {
        return itemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return itemMapper.selectAllItems();
    }

    @Override
    @Transactional
    public boolean createItem(Item item) {
        return itemMapper.insert(item) > 0;
    }

    @Override
    @Transactional
    public boolean updateItem(Item item) {
        return itemMapper.updateByPrimaryKey(item) > 0;
    }

    @Override
    @Transactional
    public boolean deleteItem(Integer itemId) {
        return itemMapper.deleteByPrimaryKey(itemId) > 0;
    }

    @Override
    public List<Item> searchItemsByKeywords(List<String> keywords) {
        // 关键词预处理
        List<String> processedKeywords = preprocessKeywords(keywords);

        // 调用Mapper层的方法进行搜索
        return itemMapper.searchItemsByKeywords(processedKeywords);
    }

    /**
     * 对关键词进行预处理，包括去除重复关键词、去除太短的关键词等。
     *
     * @param keywords 原始关键词列表
     * @return 处理后的关键词列表
     */
    private List<String> preprocessKeywords(List<String> keywords) {
        // 去除重复关键词
        Set<String> keywordSet = new HashSet<>(keywords);

        // 过滤掉过短的关键词和空白关键词，可以根据需要调整最小长度
        int MIN_KEYWORD_LENGTH = 2;
        return keywordSet.stream()
                .filter(keyword -> keyword.length() >= MIN_KEYWORD_LENGTH && !keyword.trim().isEmpty())
                .collect(Collectors.toList());
    }
}