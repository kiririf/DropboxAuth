package com.kaydalov.db;

import com.dropbox.core.DbxException;
import com.kaydalov.db.auth.DBAuth;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DbxException {
        new DBAuth().dbAuth();
    }
}
