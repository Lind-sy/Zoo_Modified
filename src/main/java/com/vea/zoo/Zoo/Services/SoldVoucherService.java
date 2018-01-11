package com.vea.zoo.Zoo.Services;

import com.vea.zoo.Zoo.Model.SoldVouchers;
import com.vea.zoo.Zoo.dao.HumanCategoryDao;
import com.vea.zoo.Zoo.dao.SoldTicketDao;
import com.vea.zoo.Zoo.dao.SoldVoucherDao;
import com.vea.zoo.Zoo.dao.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldVoucherService {

    private SoldVoucherDao soldVoucherDao;

    @Autowired
    public SoldVoucherService(
                           final SoldVoucherDao soldVoucherDao) {
        this.soldVoucherDao = soldVoucherDao;
    }

    public boolean hasVoucher(Long visitorId, String code){
        List<SoldVouchers> visitorsVouchers = soldVoucherDao.findByVisitorId(visitorId);
        for (SoldVouchers soldVoucher: visitorsVouchers
                ) {
            if(code.equals(soldVoucher.getZooVoucher().getCode())){
                return true;
            }
        }
        return false;
    }

    public void deleteUsedVoucher(Long visitorId, String code){
        soldVoucherDao.delete(soldVoucherDao.findByVisitorIdAndCode(visitorId,code).get(0));
    }
}
