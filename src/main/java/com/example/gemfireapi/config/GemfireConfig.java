package com.example.gemfireapi.config;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.Region;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
public class GemfireConfig {

    @Bean
    public ClientCache clientCache(Environment env) {
        Properties props = new Properties();
        String name = env.getProperty("gemfire.name", "SpringGemfireClient");
        String locatorString = env.getProperty("gemfire.locators", "host.docker.internal[10334]");

        // Parse locator host and port
        String locatorHost = locatorString.substring(0, locatorString.indexOf('['));
        String locatorPortStr = locatorString.substring(locatorString.indexOf('[') + 1, locatorString.indexOf(']'));
        int locatorPort = Integer.parseInt(locatorPortStr);

        props.setProperty("name", name);

        System.out.println("Connecting to GemFire with locator: " + locatorHost + ":" + locatorPort + " and name: " + name);

        ClientCache cache = new ClientCacheFactory(props)
                .addPoolLocator(locatorHost, locatorPort)
                .setPoolSubscriptionEnabled(true)
                .create();

        System.out.println("Connected to GemFire: " + (cache != null));
        return cache;
    }

    @Bean
    public Region<Object, Object> exampleRegion(ClientCache clientCache) {
        Region<Object, Object> region = clientCache
                .createClientRegionFactory(ClientRegionShortcut.PROXY)
                .create("exampleRegion");
        System.out.println("GemFire region 'exampleRegion' created: " + (region != null));
        return region;
    }
}