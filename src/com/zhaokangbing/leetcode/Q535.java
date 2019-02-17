package com.zhaokangbing.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q535 {
    private static String baseUrl = "http://tinyurl.com/";

    public static void main(String[] args) {


    }


    class Codec {
        Map<String,String> key2Url = new HashMap<>();
        Map<String,String> url2Key = new HashMap<>();
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (isEmpty(longUrl)) return null;
            StringBuilder sb = new StringBuilder(baseUrl);
            if (url2Key.containsKey(longUrl)) {
                return url2Key.get(longUrl);
            }
            String key = String.valueOf(url2Key.keySet().size());
            url2Key.put(longUrl,key);
            key2Url.put(key,longUrl);
            return key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (isEmpty(shortUrl)) return null;
            if (!key2Url.containsKey(shortUrl)) return null;
            return key2Url.get(shortUrl);
        }
        private boolean isEmpty(String str) {
            return (str== null ||str=="");
        }
    }
}
