package eu.unicredit.kite.docker_microservices.service;

import eu.unicredit.kite.docker_microservices.service.dao.KiteuserDao;
import eu.unicredit.kite.docker_microservices.service.entities.Kiteuser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitDBApplicationTests {
    @Autowired
    KiteuserDao kiteUserDao;

    @Test
    public void getAllRecordsDb() throws Exception {
        List<Kiteuser> records = kiteUserDao.findAll();
        Assert.assertEquals(3,records.size());
        Assert.assertEquals("C1",records.get(0).getCode());
    }

}
