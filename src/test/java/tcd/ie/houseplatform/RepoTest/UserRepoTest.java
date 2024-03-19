package tcd.ie.houseplatform.RepoTest;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import tcd.ie.houseplatform.Repo.UserRepo;
import tcd.ie.houseplatform.domain.User;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepoTest {
    @Autowired
    private UserRepo repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("bacc@tce.ie");
        user.setPassword("33333");
        user.setFirstName("Jack");
        user.setLastName("W");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());


    }



    @Test
    public void testFindUserByEmail(){
        String email = "ywan@tcd.ie";
        User user = repo.findByEmail(email);

        assertThat(user).isNotNull();

        String email2 = "hello@tcd.ie";
        User user1 = repo.findByEmail(email2);
        assertThat(user1).isNull();

    }

}
