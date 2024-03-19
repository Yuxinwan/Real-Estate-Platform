package tcd.ie.houseplatform.RepoTest;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import tcd.ie.houseplatform.Repo.houseRepo;
import tcd.ie.houseplatform.domain.House;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class houseTest {
    @Autowired
    private houseRepo repo1;

    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateHouse(){
        House house = new House();
        house.setTitle("A great world");
        house.setAddress("block1");
        house.setPrice(3);
        house.setBedrooms(1);
        house.setBathrooms(1);

        House savedHouse = repo1.save(house);
        House existHouse = entityManager.find(House.class, savedHouse.getId());
        assertThat(existHouse.getAddress()).isEqualTo(house.getAddress());


    }

    @Test
    public void testFindHouseById() {
        House house = new House();
        house.setTitle("Cozy Cottage");
        house.setAddress("456 Maple Ave");
        house.setPrice(200000);
        house.setBedrooms(2);
        house.setBathrooms(1);

        House savedHouse = entityManager.persist(house);
        Optional<House> foundHouse = repo1.findById(savedHouse.getId());

        assertThat(foundHouse.isPresent()).isTrue();
        assertThat(foundHouse.get().getTitle()).isEqualTo(house.getTitle());
    }

    @Test
    public void testUpdateHouse() {
        House house = new House();
        house.setTitle("Old Title");
        house.setAddress("123 Main Street");
        house.setPrice(250000);
        house.setBedrooms(2);
        house.setBathrooms(1);
        House savedHouse = entityManager.persist(house);

        savedHouse.setTitle("New Title");
        House updatedHouse = repo1.save(savedHouse);

        assertThat(updatedHouse.getTitle()).isEqualTo("New Title");
    }

    @Test
    public void testDeleteHouse() {
        House house = new House();
        house.setTitle("Test House");
        house.setAddress("123 Main Street");
        house.setPrice(300000);
        house.setBedrooms(3);
        house.setBathrooms(2);
        House savedHouse = entityManager.persist(house);

        repo1.deleteById(savedHouse.getId());
        Optional<House> deletedHouse = repo1.findById(savedHouse.getId());
        assertThat(deletedHouse).isNotPresent();
    }











}
