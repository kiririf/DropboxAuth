package com.kaydalov.db.auth;

import com.dropbox.core.*;
import com.dropbox.core.v2.DbxClientV2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class DBAuth {
    private final static String APPKEY = "ts4hxu8h56ipk9n";
    private final static String APPSECRET = "d3b8l1sxm44dht9";
    public static final  DbxAppInfo dbxAppInfo = new DbxAppInfo(APPKEY, APPSECRET);
    DbxClientV2 dbxClient;
    @Deprecated
    public DbxClientV2 dbAuth() throws IOException, DbxException{
        DbxRequestConfig dbxRequestConfig = new DbxRequestConfig(
                "JavaDropboxTutorial/1.0", Locale.getDefault().toString());

        DbxWebAuthNoRedirect dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(
                dbxRequestConfig, dbxAppInfo);
        DbxAuthFinish authFinish = dbxWithBrowser(dbxWebAuthNoRedirect);

        dbxClient = new DbxClientV2(dbxRequestConfig,
                authFinish.getAccessToken());
        return dbxClient;
    }

    private DbxAuthFinish dbxWithBrowser(DbxWebAuthNoRedirect dbxWebAuthNoRedirect) throws IOException, DbxException {
        URL authUrl = new URL(dbxWebAuthNoRedirect.start());
        System.out.println(authUrl);
        String dropboxAuthCode = new BufferedReader(new InputStreamReader(
                System.in)).readLine().trim();
        return dbxWebAuthNoRedirect.finish(dropboxAuthCode);
    }
}