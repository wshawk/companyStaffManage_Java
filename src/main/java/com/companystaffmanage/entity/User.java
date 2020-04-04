package com.companystaffmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author wsHawk
 * @Title: User
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/5/11 19:32
 */
@Entity
@Table(name = "user")
public class User  {
    @Id
    @Column(name = "uid",columnDefinition="bigint COMMENT '主键，自动生成'")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private  long uid;

    @Setter
    @Getter
    @Column( unique =true, name = "user_no",columnDefinition="varchar(32) COMMENT '用户账号'")
    private  String userNo;

    @Setter
    @Getter
    @Column(name = "password",columnDefinition="varchar(32) COMMENT '用户密码'")
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
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    // 建立用户角色中间表@JoinTable
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    @Getter
    private List<SysRole> roleList;// 一个用户具有多个角色

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
