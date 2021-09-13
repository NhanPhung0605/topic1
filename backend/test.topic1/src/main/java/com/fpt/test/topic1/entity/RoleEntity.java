package com.fpt.test.topic1.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author : Admin
 * @created : 09-Aug-21
 **/
@Entity
@Getter
@Setter
@Table(name = "role_tbl")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_code", unique = true)
    private String roleCode;

    @Column(name = "role_name", unique = true)
    private String roleName;

    @Override
    public String getAuthority() {
        return roleCode;
    }
}
