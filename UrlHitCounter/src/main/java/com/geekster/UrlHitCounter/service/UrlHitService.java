package com.geekster.UrlHitCounter.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {
    private int hitCount;
    private Map<String, Integer> usernameHitCountMap;

    public UrlHitService() {
        this.hitCount = 0;
        this.usernameHitCountMap = new HashMap<>();
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getHitCount(String username) {
        return usernameHitCountMap.getOrDefault(username, 0);
    }

    public void incrementHitCount() {
        hitCount++;
    }

    public void incrementHitCount(String username) {
        usernameHitCountMap.put(username, usernameHitCountMap.getOrDefault(username, 0) + 1);
    }



}
