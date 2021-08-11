package eu.unicredit.kite.docker_microservices.service.services;

import eu.unicredit.kite.docker_microservices.service.dao.KiteUserDao;
import eu.unicredit.kite.docker_microservices.service.entities.KiteUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class DataFillerService {

    private final KiteUserDao userDao;

    public DataFillerService(KiteUserDao userDao) {
        this.userDao = userDao;
    }

    @PostConstruct
    @Transactional
    public void fillData(){
        KiteUser u1 = KiteUser.createCompany("C1","Company 1");
        KiteUser u2 = KiteUser.createCompany("C2","Company 2");
        KiteUser u3 = KiteUser.createPerson("P1","Cesare", "Mauri");
        KiteUser u4 = KiteUser.createPerson("P1","Giuseppe", "Rossini");

        userDao.save(u1);
        userDao.save(u2);
        userDao.save(u3);
        userDao.save(u4);

    }
}
