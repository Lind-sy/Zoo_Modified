package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.HumanCatorgorys;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanCategoryDao  extends CrudRepository<HumanCatorgorys, Long> {
    @Query("select c from HumanCatorgorys c where c.category = :humanCategory")
    List<HumanCatorgorys> findByCategory(@Param("humanCategory") String humanCategory);
}
