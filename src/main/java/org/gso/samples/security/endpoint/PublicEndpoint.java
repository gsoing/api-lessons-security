package org.gso.samples.security.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(PublicEndpoint.PATH)
public class PublicEndpoint {

    public static final String PATH= "/api/v1/public";

    @GetMapping
    public ResponseEntity<String> hello(Authentication authentication) {
        return ResponseEntity.ok("It's public");
    }
}
