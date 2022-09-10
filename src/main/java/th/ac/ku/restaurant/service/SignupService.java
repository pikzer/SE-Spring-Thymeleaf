package th.ac.ku.restaurant.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.dto.SignupDto;
import th.ac.ku.restaurant.model.User;
import th.ac.ku.restaurant.repository.UserRepository;

@Service
public class SignupService {
    @Autowired
    private UserRepository repository ;

    @Autowired
    private PasswordEncoder passwordEncoder ;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username){
        return repository.findByUsername(username) == null ;
    }

    public void createUser(SignupDto signupDto) {
        User record = modelMapper.map(signupDto,User.class);
        String hashedPassword = passwordEncoder.encode(signupDto.getPassword());
        record.setPassword(hashedPassword);
        repository.save(record);
        // Non DTO
//        User record = new User();
//        record.setFirstName(user.getFirstName());
//        record.setLastName(user.getLastName());
//        record.setRole(user.getRole());
//        record.setUsername(user.getUsername());
    }

    public User getUser(String username) {
        return repository.findByUsername(username);
    }

}
