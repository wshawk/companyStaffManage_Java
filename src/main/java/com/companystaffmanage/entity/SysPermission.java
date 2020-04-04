package com.companystaffmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author wsHawk
 * @Title: SysPermission
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/6/7 11:11
 */
@Entity
public class SysPermission  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
    private long id;//主键.

    @Setter
    @Getter
    @Column(name = "name",columnDefinition="varchar(32) COMMENT '名称'")
    private String name;//名称.

    @Setter
    @Getter
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]

    @Setter
    @Getter
    @Column(name = "url",columnDefinition="varchar(32) COMMENT '资源路径'")
    private String url;//资源路径.

    @Setter
    @Getter
    @Column(name = "permission",columnDefinition="varchar(32) COMMENT '权限字符串'")
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    @Setter
    @Getter
    @Column(name = "parentId",columnDefinition="bigint COMMENT '父编号'")
    private Long parentId; //父编号

    @Setter
    @Getter
    @Column(name = "parentIds",columnDefinition="varchar(32) COMMENT '父编号列表'")
    private String parentIds; //父编号列表

    @Setter
    @Getter
    @Column(name = "available",columnDefinition="int(1) COMMENT '是否可用'")
    private Boolean available = Boolean.FALSE;

    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;
}
