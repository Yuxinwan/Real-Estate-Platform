package tcd.ie.houseplatform.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tcd.ie.houseplatform.domain.Review;

public interface reviewRepo extends JpaRepository<Review, Long> {

}
