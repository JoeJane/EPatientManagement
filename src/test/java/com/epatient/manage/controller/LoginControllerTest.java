package com.epatient.manage.controller;

import com.epatient.manage.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * EPatient starter class
 * Author: Maiara Karla
 * Created on : 10/12/2022
 */
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("Test login page Success")
    public void loginShouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    @DisplayName("Test logout page Success")
    public void logoutShouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/logout")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

}
