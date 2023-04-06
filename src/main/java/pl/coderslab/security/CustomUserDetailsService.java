package pl.coderslab.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import java.util.Collection;

@RequiredArgsConstructor
class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user =
                userRepository.findByLogin(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));

        final String password = user.getPassword();
        final Collection<? extends GrantedAuthority> authorities = null;
        final boolean accountNonExpired = true;
        final boolean accountNonLocked = true;
        final boolean credentialsNonExpired = true;
        final boolean enabled = true;

        return new CustomUserDetails(username, password, authorities, accountNonExpired,
                accountNonLocked, credentialsNonExpired, enabled);
    }
}
