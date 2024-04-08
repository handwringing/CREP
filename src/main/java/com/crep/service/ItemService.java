package com.crep.service;

import com.crep.entity.Item;

import java.util.List;

public interface ItemService {
    Item getItemById(Integer itemId);
    List<Item> getAllItems();
    boolean createItem(Item item);
    boolean updateItem(Item item);
    boolean deleteItem(Integer itemId);
    List<Item> searchItemsByKeywords(List<String> keywords);

}