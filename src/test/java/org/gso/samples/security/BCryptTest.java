package org.gso.samples.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {

    @Test
    public void testPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass1 = passwordEncoder.encode("user1password");
        String pass2 = passwordEncoder.encode("user2password");
        System.out.println(pass1 + " " + pass2);
    }
}
