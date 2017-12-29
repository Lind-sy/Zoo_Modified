package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.HumanCatorgorys;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanCategoryDao  extends CrudRepository<HumanCatorgorys, Long> {
}
