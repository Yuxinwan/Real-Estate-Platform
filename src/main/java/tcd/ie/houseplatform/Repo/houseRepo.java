package tcd.ie.houseplatform.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tcd.ie.houseplatform.domain.House;

public interface houseRepo extends JpaRepository<House, Long> {

}
