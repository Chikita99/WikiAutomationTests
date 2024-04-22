package com.test.web.helpers;
import java.util.List;

public class UserCredentials {
    public List<User> users;

    public static class User {
        public String login;
        public String password;
    }
}

