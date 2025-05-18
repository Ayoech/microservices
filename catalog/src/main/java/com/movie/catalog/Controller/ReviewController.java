package com.movie.catalog.Controller;

import com.movie.catalog.Repository.ReviewRepository;
import com.movie.catalog.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository repo;

    @GetMapping
    public List<Review> getByBookId(@RequestParam Long bookId) {
        return repo.findByBookId(bookId);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return repo.save(review);
    }
}
