package com.example.gemfireapi.controller;

import com.example.gemfireapi.service.GemfireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GemfireController {

    @Autowired
    private GemfireService gemfireService;

    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        String msg = """
            <h2>Welcome to the Spring Boot GemFire API!</h2>
            <ul>
                <li>PUT data: <code>PUT /api/put?key=yourKey&amp;value=yourValue</code></li>
                <li>GET data: <code>GET /api/get?key=yourKey</code></li>
            </ul>
            <p>Swagger UI: <a href="/swagger-ui.html">/swagger-ui.html</a></p>
            """;
        return ResponseEntity.ok().header("Content-Type", "text/html").body(msg);
    }

    @PutMapping("/put")
    public ResponseEntity<String> putData(@RequestParam String key, @RequestParam String value) {
        gemfireService.putData(key, value);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<String> getData(@RequestParam String key) {
        String value = gemfireService.getData(key);
        return ResponseEntity.ok(value);
    }
}