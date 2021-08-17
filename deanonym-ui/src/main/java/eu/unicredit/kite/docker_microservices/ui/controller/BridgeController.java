package eu.unicredit.kite.docker_microservices.ui.controller;

import eu.unicredit.kite.docker_microservices.ui.dto.KiteUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class BridgeController {

    private final RestTemplate restTemplate;
    private final String serviceHost;

    public BridgeController(RestTemplate restTemplate, @Value("${service.host}") String serviceHost) {
        this.restTemplate = restTemplate;
        this.serviceHost = serviceHost;
    }

    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/list")
    public ResponseEntity<List<KiteUserDto>> listClasses() {
        log.info("Calling list of kite users from: {}", serviceHost);
        return restTemplate
                .exchange("http://" + serviceHost + "/deanon", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<KiteUserDto>>() {
                        });
    }

    @GetMapping("/list/{code}")
    public ResponseEntity<KiteUserDto> listClasses(@PathVariable String code) {
        log.info("Calling list of kite users of: {}", code);
        return restTemplate
                .exchange("http://" + serviceHost + "/deanon/" + code, HttpMethod.GET, null,
                        new ParameterizedTypeReference<KiteUserDto>() {
                        });
    }
}
