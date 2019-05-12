package com.companystaffmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author wsHawk
 * @Title: User
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/5/11 19:32
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  long id;

    @Setter
    @Getter
    @Column(name = "user_no",columnDefinition="varchar(32) COMMENT '用户账号'")
    private  String userNo;

    @Setter
    @Getter
    @Column(name = "passwoed",columnDefinition="varchar(32) COMMENT '用户密码'")
    private  String pwd;

    @Setter
    @Getter
    @Column(name = "gender",columnDefinition="int(1) COMMENT '性别（0：男，1：女）'")
    private  String gender;

    @Setter
    @Getter
    @Column(name = "position",columnDefinition="varchar(32) COMMENT '公司职位'")
    private String position;// 职位

    @Setter
    @Getter
    @Column(name = "dept_no",columnDefinition="varchar(32) COMMENT '部门编号'")
    private  String deptNo;

    @Setter
    @Getter
    @Column(name = "company_no",columnDefinition="varchar(32) COMMENT '公司编号'")
    private String companyNo;

    @Setter
    @Getter
    @Column(name = "role_no",columnDefinition="varchar(32) COMMENT '角色编号'")
    private String roleNo;

    @Setter
    @Getter
    @Column(name = "permission_no",columnDefinition="varchar(32) COMMENT '权限编号'")
    private String perNo;

    @Setter
    @Getter
    @Column(name = "tel_num",columnDefinition="varchar(11) COMMENT '联系电话'")
    private String telNum;

    @Setter
    @Getter
    @Column(name = "level",columnDefinition="varchar(32) COMMENT '等级'")
    private String level;

    @Setter
    @Getter
    @Column(name = "create_time",columnDefinition="DATETIME  COMMENT '创建时间'")
    private Timestamp createTime;

    @Setter
    @Getter
    @Column(name = "update_time",columnDefinition="DATETIME  COMMENT '修改时间'")
   private Timestamp updateTime;

}
