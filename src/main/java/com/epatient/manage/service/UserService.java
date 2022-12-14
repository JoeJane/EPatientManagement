package com.epatient.manage.service;

import com.epatient.manage.model.Role;
import com.epatient.manage.model.SearchTerm;
import com.epatient.manage.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Service for UserService entity
 * Author: Jane Aarthy, Maiara Karla
 * Created on : 13/11/2022
 */
public interface UserService {

    public Optional<User> findById(Integer id);

    public Optional<User> findUserByUsername(String username);

    public List<User> findAll();

    public List<User> searchUsersForNurseRole(String term, String status);

    public List<User> searchUsersForAdminRole(SearchTerm searchTerm);

    public List<User> findByRoleNot(Role role);

    public List<User> findByRole(Role role);

    public void saveAllUser(List<Integer> ids, String status);

    public void saveOrUpdate(User user);

    public void changeStatusById(Integer id, boolean status);

    public void updatePassword(User user);
}
