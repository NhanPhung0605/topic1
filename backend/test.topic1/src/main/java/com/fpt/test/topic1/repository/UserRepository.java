package com.fpt.test.topic1.repository;

import com.fpt.test.topic1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Admin
 * @created : 09-Aug-21
 **/
@Repository
@Transactional(readOnly = false)
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * find by username
     * @param username
     * @return UserEntity
     */
    UserEntity findByUsername(String username);
}
