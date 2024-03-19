package tcd.ie.houseplatform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcd.ie.houseplatform.Repo.reviewRepo;
import tcd.ie.houseplatform.domain.Review;

import java.util.List;
import java.util.Optional;

@Service
public class reviewService {

    private final reviewRepo repo;


    @Autowired
    public reviewService(reviewRepo repo) {
        this.repo = repo;
    }

    public Review saveReview(Review review) {
        return repo.save(review);
    }

    public List<Review> getAllReviews() {
        return repo.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return repo.findById(id);
    }


    public void deleteReview(Long id) {
        repo.deleteById(id);
    }

    public Review updateReview(Long id, Review updatedReview) {
        return repo.findById(id)
                .map(review -> {
                    review.setNickName(updatedReview.getNickName());
                    review.setContent(updatedReview.getContent());
                    review.setRate(updatedReview.getRate());
                    return repo.save(review);
                })
                .orElseThrow(() -> new IllegalStateException("The review with id " + id + " does not exist."));
    }


}
