package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.HumanCatorgorys;
import com.vea.zoo.Zoo.Model.SoldTickets;
import com.vea.zoo.Zoo.Model.Visitor;
import com.vea.zoo.Zoo.dao.HumanCategoryDao;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.VisitorDao;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    private VisitorDao visitorDao;
    private HumanCategoryDao humanCategoryDao;

    @Autowired
    public VisitorService( final VisitorDao visitorDao,
                           final HumanCategoryDao humanCategoryDao) {
        this.visitorDao = visitorDao;
        this.humanCategoryDao = humanCategoryDao;
    }

    public List<Visitor> getAllVisitors(){
        return (List<Visitor>) visitorDao.findAll();
    }

    public List<HumanCatorgorys> getAllCategorys(){
        return (List<HumanCatorgorys>) humanCategoryDao.findAll();
    }

    public void saveVisitor(String name, String humanCategory){
        List<HumanCatorgorys> h = (List<HumanCatorgorys>) humanCategoryDao.findByCategory(humanCategory);
        final Visitor visitor = new Visitor(name,h.get(0));
        visitorDao.save(visitor);
    }
}
