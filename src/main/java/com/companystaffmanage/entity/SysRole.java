package com.companystaffmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author wsHawk
 * @Title: SysRole
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/6/7 11:10
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
    private long id; // 编号

    @Setter
    @Getter
    @Column( unique =true, name = "role",columnDefinition="varchar(255) COMMENT '角色'")
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:

    @Setter
    @Getter
    @Column(name = "description",columnDefinition="varchar(255) COMMENT '角色描述,UI界面显示使用'")
    private String description; // 角色描述,UI界面显示使用

    @Setter
    @Getter
    @Column(name = "available",columnDefinition="int(1) COMMENT '是否可用,如果不可用将不会添加给用户'")
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    @Getter
    private List<SysPermission> permissions;

    // 用户 - 角色关系定义;
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    @Getter
    private List<User> users;// 一个角色对应多个用户
}
