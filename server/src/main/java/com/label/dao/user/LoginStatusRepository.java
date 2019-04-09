package com.label.dao.user;

import com.label.po.user.LoginStatus;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoginStatusRepository extends CrudRepository<LoginStatus, Integer> {

  @Query(
      value = "select * from login_status where expired_time >= :currentTime and del = 0 ",
      nativeQuery = true)
  public List<LoginStatus> findByExpiredTimeAfter(@Param("currentTime") Date currentTime);

  @Modifying
  @Transactional(propagation = Propagation.REQUIRED)
  @Query(
      value = "update login_status set expired_time = :date where state = :state",
      nativeQuery = true)
  public void updateExpiredByState(@Param("state") String state, @Param("date") Date date);
}
