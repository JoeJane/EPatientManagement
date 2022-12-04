package com.epatient.manage.service;

import com.epatient.manage.model.Role;
import com.epatient.manage.model.SearchTerm;
import com.epatient.manage.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public void saveAllUser(List<Integer> ids, String status);

    public Optional<User> findById(Integer id);

    public void saveOrUpdate(User user);

    public List<User> findAll();

    public List<User> findByRoleNot(Role role);

    public List<User> findByRole(Role role);

    public void changeStatusById(Integer id, boolean status);

    public List<User> searchUsersForAdminRole(SearchTerm searchTerm);

    public List<User> searchUsersForNurseRole(String term, String status);

    public void updatePassword(User user);

    public Optional<User> findUserByUsername(String username);

}
