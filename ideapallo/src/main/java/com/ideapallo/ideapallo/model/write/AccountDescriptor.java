package com.ideapallo.ideapallo.model.write;

import com.ideapallo.ideapallo.model.Account;

import java.util.Map;
import java.util.function.Supplier;

public class AccountDescriptor {

    public final String username;
    public final String email;
    public final String password;

    private AccountDescriptor(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static AccountDescriptor from(Map<String, Supplier<String>> mapper) {
        return new AccountDescriptor(

                mapper.containsKey("username") ? mapper.get("username").get() : "",

                mapper.get("email").get(),
                mapper.get("password").get()
        );
    }
}
