package com.fpt.test.topic1.repository;

import com.fpt.test.topic1.entity.FormValueImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
@Repository
public interface FormValueImageRepository extends JpaRepository<FormValueImageEntity, Long> {
}
