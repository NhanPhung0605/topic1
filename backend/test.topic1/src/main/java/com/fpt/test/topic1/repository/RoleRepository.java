package com.fpt.test.topic1.repository;

import com.fpt.test.topic1.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Admin
 * @created : 09-Aug-21
 **/
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
