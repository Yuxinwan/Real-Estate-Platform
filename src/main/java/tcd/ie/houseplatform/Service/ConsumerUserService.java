package tcd.ie.houseplatform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tcd.ie.houseplatform.Repo.UserRepo;
import tcd.ie.houseplatform.domain.ConsumerUser;
import tcd.ie.houseplatform.domain.User;


@Service  // 添加这个注解
public class ConsumerUserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new ConsumerUser(user);
    }
}
