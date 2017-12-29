package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.Model.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorDao extends CrudRepository<Visitor, Long>{

}
