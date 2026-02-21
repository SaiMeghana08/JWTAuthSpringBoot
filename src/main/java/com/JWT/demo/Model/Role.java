package com.JWT.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ROLE")
public class Role {
    @Id
    private String roleName;
    private String roleDesc;
}
