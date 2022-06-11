package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Data
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "Most Be Write Yours Name !")
    @Column(unique = true,nullable = false)
    @NotEmpty(message = "Username is required")
    @Length(min = 6,max = 20,message = "Username must be between 6 and 20 length range")
    private String username;
    @NotEmpty(message = "Password is required")
    private String password;
    @NotEmpty(message = "Most Be Write Yours Email !")
    private String email;
    @NotEmpty(message = "Most Be Write Yours Phone Number !")
    private String phoneNumber;
    @NotEmpty(message = "Most Be Write Or User !")
    @Pattern(regexp = "(admin|user)")
    private String role;

    // The RelationShip Between User and Others ...


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set <Troubles> troubles;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private ServiceEvaluation ServiceEvaluation;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Invoice>invoices;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}

