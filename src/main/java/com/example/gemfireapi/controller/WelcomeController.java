package com.example.gemfireapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        String msg = """
            <h2>Welcome to the Spring Boot GemFire API!</h2>
            <ul>
                <li>PUT data: <code>PUT /api/put?key=yourKey&amp;value=yourValue</code></li>
                <li>GET data: <code>GET /api/get?key=yourKey</code></li>
            </ul>

            <h3> curl -X PUT "http://localhost:8881/api/put?key=myKeyarul&value=demo"
  </h3>
          <h3>
                curl "http://localhost:8881/api/get?key=myKeyarul"
                </h3>


            <p>Swagger UI: <a href="/swagger-ui.html">/swagger-ui.html</a></p>
            """;
        return ResponseEntity.ok().header("Content-Type", "text/html").body(msg);
    }
}