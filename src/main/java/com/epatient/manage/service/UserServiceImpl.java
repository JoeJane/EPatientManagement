package com.epatient.manage.service;

import com.epatient.manage.model.Patient;
import com.epatient.manage.model.Role;
import com.epatient.manage.model.SearchTerm;
import com.epatient.manage.model.User;
import com.epatient.manage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveAllUser(List<Integer> ids, String status) {
        List<User> users = userRepository.findAllById(ids);
        boolean isDeleted = status.equals("1") ? false : true;
        users.forEach(user -> {
            user.setDeleted(isDeleted);
        });

        userRepository.saveAll(users);
    }

    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("USER_NOT_FOUND", username)));
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByRoleNot(Role role) {
        return userRepository.findByRoleNot(role);
    }

    @Override
    public List<User> findByRole(Role role){
        return userRepository.findByRole(role);
    }

    @Override
    public void saveOrUpdate(User user) {
        Integer userId = user.getUserId();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        Optional<User> userData = userId == null ? Optional.empty() : findById(userId);

        if (userData.isPresent()) {
            User userTemp = userData.get();

            userTemp.setFirstName(user.getFirstName());
            userTemp.setLastName(user.getLastName());
            // userTemp.setRole(user.getRole());
            userTemp.setDateOfBirth(user.getDateOfBirth());
            userTemp.setGender(user.getGender());
            // userTemp.setBloodGroup(user.getBloodGroup());
            userTemp.setEmail(user.getEmail());
            userTemp.setPhoneNumber(user.getPhoneNumber());
            userTemp.setAddress(user.getAddress());
            userTemp.setAddressNo(user.getAddressNo());
            userTemp.setCity(user.getCity());
            userTemp.setProvince(user.getProvince());
            userTemp.setPostalCode(user.getPostalCode());
            userTemp.setCountry(user.getCountry());
            /*userTemp.setEmergencyFirstName(user.getEmergencyFirstName());
            userTemp.setEmergencyLastName(user.getEmergencyLastName());
            userTemp.setEmergencyEmail(user.getEmergencyEmail());
            userTemp.setEmergencyPhone(user.getEmergencyPhone());*/
            userTemp.setPassword(encodedPassword);

            userRepository.save(userTemp);
        } else {
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }

    }

    @Override
    public void changeStatusById(Integer id, boolean status) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        user.setDeleted(status);
        userRepository.save(user);
    }

    public List<User> searchUsersForNurseRole(String term, String status) {
        List<Role> roles = List.of(Role.PATIENT);
        return search(term, status, roles);
    }

    public List<User> searchUsersForAdminRole(SearchTerm searchTerm) {
        List<Role> roles = null;
        if(searchTerm.getRole() != null)
            roles = List.of(searchTerm.getRole());
        else
            roles = Arrays.stream(Role.values()).filter(r -> r != Role.ADMIN).collect(Collectors.toList());
        return search(searchTerm.getValue(), searchTerm.getStatus(), roles);
    }

    private List<User> search(String term, String status, List<Role> roles) {
        if (status.equals("1") || status.equals("2")) {
            boolean isDeleted = status.equals("1") ? false : true;
            return userRepository.findUser(term, isDeleted, roles);
        } else {
            return userRepository.findUser(term, roles);
        }
    }

    public void updatePassword(User user) {
        Optional<User> userOptional = findById(user.getUserId());
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        User tempUser = userOptional.get();
        tempUser.setPassword(encodedPassword);
        userRepository.save(tempUser);
    }


}
