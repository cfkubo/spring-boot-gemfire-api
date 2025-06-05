package com.example.gemfireapi.service;

import org.apache.geode.cache.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GemfireService {

    private final Region<Object, Object> region;

    @Autowired
    public GemfireService(Region<Object, Object> region) {
        this.region = region;
    }

    public void putData(String key, String value) {
        region.put(key, value);
    }

    public String getData(String key) {
        Object value = region.get(key);
        return value != null ? value.toString() : null;
    }
}