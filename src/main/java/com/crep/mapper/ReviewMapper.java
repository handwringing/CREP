package com.crep.mapper;

import com.crep.entity.Review;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReviewMapper {

    @Select("SELECT * FROM review WHERE review_id = #{reviewId}")
    Review selectByPrimaryKey(@Param("reviewId") Integer reviewId);

    @Insert("INSERT INTO review (user_id, item_id, rating, comments) " +
            "VALUES (#{userId}, #{itemId}, #{rating}, #{comments})")
    @Options(useGeneratedKeys = true, keyProperty = "reviewId")
    int insert(Review review);

    @Update("UPDATE review SET user_id = #{userId}, item_id = #{itemId}, rating = #{rating}, " +
            "comments = #{comments} WHERE review_id = #{reviewId}")
    int updateByPrimaryKey(Review review);

    @Delete("DELETE FROM review WHERE review_id = #{reviewId}")
    int deleteByPrimaryKey(@Param("reviewId") Integer reviewId);

    @Select("SELECT * FROM review")
    List<Review> selectAllReviews();

    @Update({
            "<script>",
            "UPDATE review",
            "<set>",
            "<if test='userId != null'>user_id = #{userId},</if>",
            "<if test='itemId != null'>item_id = #{itemId},</if>",
            "<if test='rating != null'>rating = #{rating},</if>",
            "<if test='comments != null'>comments = #{comments}</if>",
            "</set>",
            "WHERE review_id = #{reviewId}",
            "</script>"
    })
    int updateByPrimaryKeySelective(Review review);
    // Other potential methods might include:
    // - Retrieving all reviews for a specific item.
    // - Retrieving all reviews from a specific user.
    // - Updating only the rating.
    // - Updating only the comments.
    // etc.
}