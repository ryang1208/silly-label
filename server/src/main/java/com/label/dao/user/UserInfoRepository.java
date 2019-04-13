package com.label.dao.user;

import com.label.po.user.UserInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {

    public UserInfo findByUsername(String userName);

    /**
     * 更新密码
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "update user_info set password = :password where id =:id", nativeQuery = true)
    public void updatePassword(@Param("id") Integer id, @Param("password") String password);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "update user_info set password = :password where username =:username", nativeQuery = true)
    public void update(@Param("username") String username, @Param("password") String password);

}
