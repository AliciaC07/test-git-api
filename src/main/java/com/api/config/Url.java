package com.api.config;

public class Url {

    public final static String DISPATCH = "/dispatches";
    public final static String CONTENTS = "/contents";
    public final static String URL = "https://api.github.com/repos/";
    public final static String VERSION_FILE = "/control-version.yaml";

    public static String buildUrl(String repoOwner, String repo){
        return URL+repoOwner+"/"+repo+DISPATCH;

    }

    public static String buildUrlContent(String repo){
        return URL+Repos.OWNER+"/"+repo+CONTENTS+VERSION_FILE;


    }
}
