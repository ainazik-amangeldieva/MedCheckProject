package hospital.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hospital.entity.Role;
import hospital.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor

public class MyUserDetails implements UserDetails {

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private boolean enabled;

    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        userName = user.getUserName();
        firstName = user.getPerson().getFirstName();
        lastName = user.getPerson().getLastName();
        password = user.getPassword();
        email = user.getPerson().getEmail();
        enabled = true;
        authorities = getAuthorities(user.getRoles());
    }

    public MyUserDetails(String username, String firstName, String lastName, String password) {
        userName = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
//        this.email = email;
        enabled = true;
//        authorities = roles;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            role.getPrivileges().stream()
//                    .map(p -> new SimpleGrantedAuthority(p.getName()))
//                    .forEach(authorities::add);
        }

        return authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }


}
