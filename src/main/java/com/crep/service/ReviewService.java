package com.crep.service;

import com.crep.entity.Review;
import java.util.List;

public interface ReviewService {
    Review getReviewById(Integer reviewId);
    List<Review> getAllReviews();
    boolean createReview(Review review);
    boolean updateReview(Review review);
    boolean deleteReview(Integer reviewId);
    // Additional methods based on business logic
    // For example, getting reviews for a specific item or user
}