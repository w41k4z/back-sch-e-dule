package com.hiu.backschedule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiu.backschedule.connection.PostgresAccess;
import com.hiu.backschedule.model.User;
import com.hiu.backschedule.model.UserAccount;

import jakarta.servlet.http.HttpServletRequest;

import orm.database.connection.DatabaseConnection;
import orm.utilities.Treatment;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping("/account/create")
    public void createAccount(HttpServletRequest request) {
        try {
            DatabaseConnection connection = new PostgresAccess("jdbc:postgresql://localhost:5432/sch_e_dule", "walker",
                    "w41k4z!");

            User newUser = new User();
            newUser.setName(request.getParameter("name"));
            newUser.setFirstName(request.getParameter("firstName"));
            newUser.setBirthday(request.getParameter("birthday"));
            newUser.create(connection);

            UserAccount newUserAccount = new UserAccount();
            newUserAccount.setUserID(newUser.getUserID());
            newUserAccount.setEmail(request.getParameter("email"));
            newUserAccount.setPassword(request.getParameter("password"));
            newUserAccount.setCreationDate(Treatment.getCurrentDate(true));
            newUserAccount.create(connection);

            connection.commit();
            connection.close();
        } catch (Exception exc) {
            return exc;
        }
    }
}