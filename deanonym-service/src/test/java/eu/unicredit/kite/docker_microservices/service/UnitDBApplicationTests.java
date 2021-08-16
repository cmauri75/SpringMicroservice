package eu.unicredit.kite.docker_microservices.service;

import eu.unicredit.kite.docker_microservices.service.dao.KiteUserDao;
import eu.unicredit.kite.docker_microservices.service.entities.KiteUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitDBApplicationTests {
    @Autowired
    KiteUserDao kiteUserDao;

    @Test
    public void getAllRecordsDb() throws Exception {
        List<KiteUser> records = kiteUserDao.findAll();
        Assert.assertEquals(3,records.size());
        Assert.assertEquals("C1",records.get(0).getCode());
    }

}
