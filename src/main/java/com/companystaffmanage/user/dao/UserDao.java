package com.companystaffmanage.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.companystaffmanage.entity.User;

import java.io.Serializable;

/**
 * @author wsHawk
 * @Title: LoginDao
 * @ProjectName companystaffmanage
 * @Description: TODO
 * @date 2019/5/11 19:26
 */

@Repository
public interface UserDao extends JpaRepository<User, Serializable> {

    User findByUserNo(String userNo);

}
