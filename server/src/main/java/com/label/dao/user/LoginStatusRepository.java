package com.label.dao.user;

import com.label.po.user.LoginStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoginStatusRepository extends CrudRepository<LoginStatus,Integer> {

    public List<LoginStatus> findByExpiredTimeAfter(Date currentTime);
}
