package com.geekster.UrlHitCounter.controller;

import com.geekster.UrlHitCounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    private UrlHitService urlHitService;

    @GetMapping("count")
    public ResponseEntity<Map<String, Integer>> getHitCount() {
        int hitCount = urlHitService.getHitCount();
        Map<String, Integer> response = new HashMap<>();
        response.put("visitors", hitCount);
        return ResponseEntity.ok(response);
    }

    @GetMapping("username/{username}/count")
    public ResponseEntity<Map<String, Object>> getUsernameHitCount(@PathVariable String username) {
        urlHitService.incrementHitCount(username);
        int hitCount = urlHitService.getHitCount(username);
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("hitcount", hitCount);
        return ResponseEntity.ok(response);
    }
}
