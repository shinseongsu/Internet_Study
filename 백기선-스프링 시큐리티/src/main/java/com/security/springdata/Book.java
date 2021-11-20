package com.security.springdata;

import com.security.account.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @ManyToOne
    private Account author;

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Account getAuthor() {
        return author;
    }

    public Book setAuthor(Account account) {
        this.author = account;
        return this;
    }
}
