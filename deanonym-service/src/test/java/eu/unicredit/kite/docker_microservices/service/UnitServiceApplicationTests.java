package eu.unicredit.kite.docker_microservices.service;

import eu.unicredit.kite.docker_microservices.service.dao.KiteuserDao;
import eu.unicredit.kite.docker_microservices.service.entities.Kiteuser;
import org.junit.Before;
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
@AutoConfigureMockMvc
@SpringBootTest
public class UnitServiceApplicationTests {
    @MockBean
    KiteuserDao kiteUserDaoMock;

    @Autowired
    MockMvc mockMvc;

    Kiteuser RECORD_1 = new Kiteuser("P1", "Cesare", "Mauri", null, false);
    Kiteuser RECORD_2 = new Kiteuser("C1", null, null, "TInvention", true);

    @Before
    public void setup() {
        List<Kiteuser> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));
        Mockito.when(kiteUserDaoMock.findAll()).thenReturn(records);
    }

    @Test
    public void getAllRecordsService() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/deanon")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Cesare")))
                .andExpect(jsonPath("$[1].company", is(true)));
    }


}
