package com.chinhnd.security.entity.auth;

import com.chinhnd.security.common.Constrants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static com.chinhnd.security.common.Constrants.CommonEntityECColumn.FIRST_NAME;
import static com.chinhnd.security.common.Constrants.CommonEntityECColumn.LAST_NAME;
import static com.chinhnd.security.common.Constrants.Message.VALIDATE_MAX_SIZE_60;
import static com.chinhnd.security.common.Constrants.Message.VALIDATE_THE_FIELD;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_account")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @NotNull(message = VALIDATE_THE_FIELD)
    private Integer id;

    @Column(name = FIRST_NAME)
    @Size(max = Constrants.MAX_60, message = VALIDATE_MAX_SIZE_60)
    @NotNull(message = VALIDATE_THE_FIELD)
    private String firstName;

    @Column(name = LAST_NAME)
    @Size(max = Constrants.MAX_60, message = VALIDATE_MAX_SIZE_60)
    @NotNull(message = VALIDATE_THE_FIELD)
    private String lastName;

    @Size(max = Constrants.MAX_60, message = VALIDATE_MAX_SIZE_60)
    @NotNull(message = VALIDATE_THE_FIELD)
    private String email;

    @Size(max = Constrants.MAX_60, message = VALIDATE_MAX_SIZE_60)
    @NotNull(message = VALIDATE_THE_FIELD)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
