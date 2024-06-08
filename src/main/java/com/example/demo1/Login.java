package com.example.demo1;

import java.io.IOException;
import java.util.HashMap;
import java.io.File;

public class Login {
    HashMap<String, String> infos = new HashMap<String, String>();


    Login() {
        infos.put("admin", "admin");
    }

    protected HashMap<String, String> getLoginInfo() {
        return infos;
    }

}
