package com.crep.mapper;

import com.crep.entity.Item;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {

    @Select("SELECT * FROM item WHERE item_id = #{itemId}")
    Item selectByPrimaryKey(@Param("itemId") Integer itemId);

    @Insert("INSERT INTO item (owner_id, name, price, status, description, picture) " +
            "VALUES (#{ownerId}, #{name}, #{price}, #{status}, #{description}, #{picture})")
    int insert(Item item);

    @Update("UPDATE item SET owner_id=#{ownerId}, name=#{name}, price=#{price}, " +
            "status=#{status}, description=#{description}, picture=#{picture} " +
            "WHERE item_id=#{itemId}")
    int updateByPrimaryKey(Item item);

    @Delete("DELETE FROM item WHERE item_id = #{itemId}")
    int deleteByPrimaryKey(@Param("itemId") Integer itemId);

    @Select("SELECT * FROM item")
    List<Item> selectAllItems();

    @SelectProvider(type = ItemSqlProvider.class, method = "searchItemsByKeywords")
    List<Item> searchItemsByKeywords(@Param("keywords") List<String> keywords);

    class ItemSqlProvider {
        public String searchItemsByKeywords(Map<String, Object> params) {
            List<String> keywords = (List<String>) params.get("keywords");
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM item WHERE ");
            for (int i = 0; i < keywords.size(); i++) {
                String keyword = keywords.get(i);
                sb.append("(name LIKE CONCAT('%', #{keywords[" + i + "]}, '%') OR ");
                sb.append("description LIKE CONCAT('%', #{keywords[" + i + "]}, '%'))");
                if (i < keywords.size() - 1) {
                    sb.append(" AND ");  // Use OR for any keyword match, AND for all keywords match
                }
            }
            return sb.toString();
        }
    }
    // 其他你想要提供的Mapper方法...
}