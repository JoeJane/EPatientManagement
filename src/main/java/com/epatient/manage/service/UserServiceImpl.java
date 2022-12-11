package com.epatient.manage.service;

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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation for @UserService and @UserDetailsService entities
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    /**
     * Load user based on ID
     * @param id User id
     * @return User
     */
    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * Find user based on username
     * @param username Username
     * @return User
     */
    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    /**
     * Search nursee users
     * @param term Search term
     * @param status Status
     * @return List of users
     */
    public List<User> searchUsersForNurseRole(String term, String status) {
        List<Role> roles = List.of(Role.PATIENT);
        return search(term, status, roles);
    }

    /**
     * Load all users
     * @return list of users
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Load user whose role is not passed parameter
     * @param role User role
     * @return List of users
     */
    @Override
    public List<User> findByRoleNot(Role role) {
        return userRepository.findByRoleNot(role);
    }

    /**
     * Load user based on @Role
     * @param role User role
     * @return List of users
     */
    @Override
    public List<User> findByRole(Role role){
        return userRepository.findByRole(role);
    }

    /**
     * Update multiple users
     * @param ids User ids
     * @param status Status
     */
    @Override
    public void saveAllUser(List<Integer> ids, String status) {
        List<User> users = userRepository.findAllById(ids);
        boolean isDeleted = status.equals("1") ? false : true;
        users.forEach(user -> {
            user.setDeleted(isDeleted);
        });

        userRepository.saveAll(users);
    }

    /**
     * Get user based on username
     * @param username Username
     * @return UserDetails
     * @throws UsernameNotFoundException Username not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("USER_NOT_FOUND", username)));
    }

    /**
     * Save or update user
     * @param user User entity
     */
    @Override
    public void saveOrUpdate(User user) {
        Integer userId = user.getUserId();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        Optional<User> userData = userId == null ? Optional.empty() : findById(userId);

        if (userData.isPresent()) {
            User userTemp = userData.get();

            userTemp.setFirstName(user.getFirstName());
            userTemp.setLastName(user.getLastName());
            userTemp.setDateOfBirth(user.getDateOfBirth());
            userTemp.setGender(user.getGender());
            userTemp.setEmail(user.getEmail());
            userTemp.setPhoneNumber(user.getPhoneNumber());
            userTemp.setAddress(user.getAddress());
            userTemp.setAddressNo(user.getAddressNo());
            userTemp.setCity(user.getCity());
            userTemp.setProvince(user.getProvince());
            userTemp.setPostalCode(user.getPostalCode());
            userTemp.setCountry(user.getCountry());

            userRepository.save(userTemp);
        } else {
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }

    }

    /**
     * Change user status
     * @param id User ID
     * @param status Status
     */
    @Override
    public void changeStatusById(Integer id, boolean status) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        user.setDeleted(status);
        userRepository.save(user);
    }



    /**
     * Search non-admin users
     * @param searchTerm Search term
     * @return List of users
     */
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

    /**
     * Update user password
     * @param user User
     */
    public void updatePassword(User user) {
        Optional<User> userOptional = findById(user.getUserId());
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        User tempUser = userOptional.get();
        tempUser.setPassword(encodedPassword);
        userRepository.save(tempUser);
    }
}
