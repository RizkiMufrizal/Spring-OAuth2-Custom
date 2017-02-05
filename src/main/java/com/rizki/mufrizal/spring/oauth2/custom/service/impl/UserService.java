package com.rizki.mufrizal.spring.oauth2.custom.service.impl;

import com.rizki.mufrizal.spring.oauth2.custom.domain.UserRole;
import com.rizki.mufrizal.spring.oauth2.custom.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Feb 5, 2017
 * @Time 7:31:02 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.service.impl
 *
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.rizki.mufrizal.spring.oauth2.custom.domain.User user = userRepository.LoginUser(username);

        if (user != null) {
            List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());
            return buildUserForAuthentication(user, authorities);
        }

        return null;
    }

    private User buildUserForAuthentication(com.rizki.mufrizal.spring.oauth2.custom.domain.User user, List<GrantedAuthority> grantedAuthorities) {
        return new User(user.getUsername(), user.getPassword(), user.getIsActive(), true, true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        userRoles.stream().forEach((userRole) -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().toString()));
        });

        return new ArrayList<>(grantedAuthorities);
    }

}
