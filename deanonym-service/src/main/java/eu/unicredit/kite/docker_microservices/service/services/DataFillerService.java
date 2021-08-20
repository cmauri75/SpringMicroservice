package eu.unicredit.kite.docker_microservices.service.services;

import eu.unicredit.kite.docker_microservices.service.dao.KiteuserDao;
import eu.unicredit.kite.docker_microservices.service.entities.Kiteuser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class DataFillerService {

    private final KiteuserDao userDao;

    public DataFillerService(KiteuserDao userDao) {
        this.userDao = userDao;
    }

    @PostConstruct
    @Transactional
    public void fillData(){
        Kiteuser u1 = Kiteuser.createCompany("C1","Company 1");
        Kiteuser u2 = Kiteuser.createCompany("C2","Company 2");
        Kiteuser u3 = Kiteuser.createPerson("P1","Cesare", "Mauri");
        Kiteuser u4 = Kiteuser.createPerson("P1","Giuseppe", "Rossini");

        userDao.save(u1);
        userDao.save(u2);
        userDao.save(u3);
        userDao.save(u4);

    }
}
