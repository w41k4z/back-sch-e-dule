package com.hiu.backschedule.model;

import orm.database.object.relation.Relation;
import orm.annotation.Column;
import orm.annotation.PrimaryKey;
import orm.annotation.Table;

import java.sql.Date;

@Table(name = "user", columnCount = 4)
public class User extends Relation<User> {

    @PrimaryKey(column = @Column(name = "user_id"), prefix = "STD", length = 10, sequence = "user_sequence")
    private String userID;

    @Column
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column
    private Date birthday;

    // constructor
    public User() throws Exception {
        super();
    }

    // setter
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // for the input
    public void setBirthday(String birthday) {
        this.setBirthday(birthday == null ? null : Date.valueOf(birthday.trim()));
    }

    // getter
    public String getUserID() {
        return this.userID;
    }

    public String getName() {
        return this.name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Date getBirthday() {
        return this.birthday;
    }
}
