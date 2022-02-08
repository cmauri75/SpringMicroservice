package eu.unicredit.kite.docker_microservices.service.services;

import eu.unicredit.kite.docker_microservices.service.dao.KiteuserDao;
import eu.unicredit.kite.docker_microservices.service.entities.Kiteuser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Example bean for startup data and initialization.
 * No more needed as liquibase will load data as needed
 */
@Component
@AllArgsConstructor
public class DataFillerService implements ApplicationRunner {
    private final KiteuserDao userDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userDao.save(Kiteuser.builder().code("S1").companyName("Start Company").isCompany(true).build());
        userDao.save(Kiteuser.builder().code("S2").name("Start").surname("Person").isCompany(false).build());
    }
}
