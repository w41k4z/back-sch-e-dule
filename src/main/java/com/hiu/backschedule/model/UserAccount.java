package com.hiu.backschedule.model;

import orm.database.object.relation.Relation;
import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;

import java.sql.Date;

import com.hiu.backschedule.validation.PasswordChecker;

@Table(name = "user_account", columnCount = 5)
public class UserAccount extends Relation<UserAccount> {

    @PrimaryKey(column = @Column(name = "user_account_id"), prefix = "STA", length = 10, sequence = "user_account_sequence")
    private String userAccountID;

    @Column(name = "user_id")
    private String userID;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "creation_date")
    private Date creationDate;

    // constructor
    public UserAccount() throws Exception {
        super();
    }

    // setter
    public void setUserAccountID(String userAccountID) {
        this.userAccountID = userAccountID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public void setPassword(String password) throws Exception {
        PasswordChecker checker = new PasswordChecker(password);
        checker.check();
        this.password = password;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    // getter
    public String getUserAccountID() {
        return this.userAccountID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }
}
