package org.mmpp.raspberrypi.ledflash.domain.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.mmpp.raspberrypi.ledflash.domain.model.GPIO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GPIODaoImpl implements GPIODao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List findAll() {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(GPIO.class);
        return criteria.list();
    }

}
