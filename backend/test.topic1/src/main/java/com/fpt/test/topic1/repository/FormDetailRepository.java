package com.fpt.test.topic1.repository;

import com.fpt.test.topic1.entity.FormDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
@Repository
public interface FormDetailRepository extends JpaRepository<FormDetailEntity, Long> {

    @Query("SELECT fd FROM FormDetailEntity fd INNER JOIN FormEntity f ON fd.formEntity.formId = f.formId WHERE f.formName = :formName")
    List<FormDetailEntity> getFormDetailByFormName(@Param("formName") String formName);

    @Query("SELECT fd FROM FormDetailEntity fd INNER JOIN FormEntity f ON fd.formEntity.formId = f.formId WHERE f.formId = :formId")
    List<FormDetailEntity> getFormDetailByFormId(@Param("formId")Long formId);

}
