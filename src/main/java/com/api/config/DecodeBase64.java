package com.api.config;

import java.nio.charset.StandardCharsets;


public class DecodeBase64 {



    public static String getContentDecode(String content){
        byte[] fileContents = java.util.Base64.getDecoder().decode(content);
        return new String(fileContents, StandardCharsets.UTF_8);
    }
}
