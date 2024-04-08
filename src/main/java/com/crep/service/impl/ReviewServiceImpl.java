package com.crep.service.impl;

import com.crep.entity.Review;
import com.crep.mapper.ReviewMapper;
import com.crep.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewServiceImpl(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    @Override
    public Review getReviewById(Integer reviewId) {
        return reviewMapper.selectByPrimaryKey(reviewId);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewMapper.selectAllReviews();
    }

    @Override
    @Transactional
    public boolean createReview(Review review) {
        return reviewMapper.insert(review) > 0;
    }

    @Override
    @Transactional
    public boolean updateReview(Review review) {
        return reviewMapper.updateByPrimaryKeySelective(review) > 0;
    }

    @Override
    @Transactional
    public boolean deleteReview(Integer reviewId) {
        return reviewMapper.deleteByPrimaryKey(reviewId) > 0;
    }

    // Implement additional methods as needed based on business logic
}