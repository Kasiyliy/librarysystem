package com.sberteam.librarysustem.security;

import com.sberteam.librarysustem.models.AuthenticableUsers;
import com.sberteam.librarysustem.models.Roles;
import com.sberteam.librarysustem.repositories.AuthenticableUsersRepository;
import com.sberteam.librarysustem.repositories.BasicUsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private AuthenticableUsersRepository authenticableUsersRepository;

    public CustomUserDetailsService(AuthenticableUsersRepository authenticableUsersRepository) {
        this.authenticableUsersRepository = authenticableUsersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthenticableUsers user = authenticableUsersRepository.findByUsername(username);
        User secureUser = getUserFromUserEntity(user , convertRolesToGrantedAuthorities(user.getRoles()));
        return secureUser;
    }

    private User getUserFromUserEntity(AuthenticableUsers users, List<GrantedAuthority> authorities){
        return  new User(users.getUsername(), users.getPassword(),true , true , true , true, authorities);
    }

    private List<GrantedAuthority> convertRolesToGrantedAuthorities(Set<Roles> roles){
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for(Roles role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new ArrayList<>(grantedAuthorities);
    }
}
