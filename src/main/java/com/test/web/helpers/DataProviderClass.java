package com.test.web.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;

public class DataProviderClass {

    public static List<UserCredentials.User> getUsers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = DataProviderClass.class.getResourceAsStream("/fixtures/account_data.json");
            UserCredentials credentials = mapper.readValue(is, UserCredentials.class);
            return credentials.users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

