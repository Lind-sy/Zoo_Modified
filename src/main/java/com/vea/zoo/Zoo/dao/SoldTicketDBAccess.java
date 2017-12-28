package com.vea.zoo.Zoo.dao;

import com.vea.zoo.Zoo.SoldTickets;
import org.springframework.stereotype.Repository;

@Repository
public class SoldTicketDBAccess implements SoldTicketDao{
    //TODO Overridden functions
    @Override
    public <S extends SoldTickets> S save(S s) {
        return null;
    }

    @Override
    public <S extends SoldTickets> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public SoldTickets findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<SoldTickets> findAll() {
        return null;
    }

    @Override
    public Iterable<SoldTickets> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(SoldTickets soldTickets) {

    }

    @Override
    public void delete(Iterable<? extends SoldTickets> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
