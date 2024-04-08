package com.crep.controller;

import com.crep.entity.Item;
import com.crep.service.ItemService;
import com.crep.util.KeywordTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // 获取所有物品列表
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    // 根据ID查询物品
    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer itemId) {
        Item item = itemService.getItemById(itemId);
        return item != null ? new ResponseEntity<>(item, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 创建物品
    @PostMapping("/create")
    public ResponseEntity<Void> createItem(@RequestBody Item item) {
        boolean isCreated = itemService.createItem(item);
        return isCreated ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 更新物品信息
    @PutMapping("/update")
    public ResponseEntity<Void> updateItem(@RequestBody Item item) {
        boolean isUpdated = itemService.updateItem(item);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 删除物品
    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer itemId) {
        boolean isDeleted = itemService.deleteItem(itemId);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItems(@RequestParam String searchString) {
        // 使用分词工具将连续字符串分割为关键词列表
        List<String> keywords = KeywordTokenizer.tokenize(searchString);

        // 调用服务层的方法进行搜索
        List<Item> items = itemService.searchItemsByKeywords(keywords);

        // 返回搜索结果
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    // 其他可能需要的Item相关功能，比如搜索、过滤等
    // ...

}