package com.security.common;

import com.security.account.Account;
import com.security.account.AccountService;
import com.security.springdata.Book;
import com.security.springdata.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataGenerator implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account seongsu = createUser("seongsu");
        Account noah = createUser("noah");

        createBook("spring", seongsu);
        createBook("hibernate", noah);
    }

    private void createBook(String title, Account author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.save(book);
    }

    private Account createUser(String username) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword("123");
        account.setRole("USER");
        return accountService.createNewAccount(account);
    }
}
