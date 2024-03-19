package tcd.ie.houseplatform.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcd.ie.houseplatform.Service.reviewService;
import tcd.ie.houseplatform.domain.Review;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class reviewController {
    
    @Autowired
    private reviewService service;

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        Review newReview = service.saveReview(review);
        return ResponseEntity.ok(newReview);
    }

    @GetMapping ("/getAll")// 响应GET请求，用于获取所有评论
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping("/id")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        return service.getReviewById(id)
                .map(ResponseEntity :: ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Review> deleteById(@PathVariable Long id){
        service.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/id")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        try {
            Review updatedReview = service.updateReview(id, review);
            return ResponseEntity.ok(updatedReview);
        } catch (IllegalStateException e) {
            return ResponseEntity.notFound().build();
        }
    }




}
