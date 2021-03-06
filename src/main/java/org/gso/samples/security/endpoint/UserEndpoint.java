package org.gso.samples.security.endpoint;

import java.security.Principal;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.gso.samples.security.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserEndpoint.PATH)
@Slf4j
public class UserEndpoint {

    public static final String PATH = "/api/v1/user";

    @GetMapping
    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
      return ResponseEntity
              .ok(
                      UserDto.builder()
                              .username(authentication.getName())
                              .roles(
                                      authentication.getAuthorities()
                                              .stream()
                                              .map(GrantedAuthority::getAuthority)
                                              .collect(Collectors.toList())
                              )
              .build());
    }
}
