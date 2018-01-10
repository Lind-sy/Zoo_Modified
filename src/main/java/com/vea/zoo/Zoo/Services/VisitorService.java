package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.HumanCatorgorys;
import com.vea.zoo.Zoo.Model.Visitor;
import com.vea.zoo.Zoo.dao.HumanCategoryDao;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    private VisitorDao visitorDao;
    private HumanCategoryDao humanCategoryDao;
    private SoldTicketDao soldTicketDao;

    @Autowired
    public VisitorService( final VisitorDao visitorDao,
                           final HumanCategoryDao humanCategoryDao,
                           final SoldTicketDao soldTicketDao) {
        this.visitorDao = visitorDao;
        this.humanCategoryDao = humanCategoryDao;
        this.soldTicketDao = soldTicketDao;
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

    public void deleteVisitor(Long visitorId) {
        soldTicketDao.delete(soldTicketDao.findByVisitorId(visitorId));
        visitorDao.delete(visitorId);
    }

    public void updateVisitor(String categoryName,String name,final Long visitorId) {
        List<HumanCatorgorys> h = (List<HumanCatorgorys>) humanCategoryDao.findByCategory(categoryName);
        final Visitor visitor = visitorDao.findOne(visitorId);
        visitor.setVisitorHumanCategory(h.get(0));
        visitor.setName(name);
        visitorDao.save(visitor);
    }
}
