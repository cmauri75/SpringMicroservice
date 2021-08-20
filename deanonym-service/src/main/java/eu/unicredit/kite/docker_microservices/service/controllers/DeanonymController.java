package eu.unicredit.kite.docker_microservices.service.controllers;


import eu.unicredit.kite.docker_microservices.service.dtos.KiteuserDto;
import eu.unicredit.kite.docker_microservices.service.services.DeanonymService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/deanon")
public class DeanonymController {


    private final DeanonymService deanonymService;

    public DeanonymController(DeanonymService deanonymService) {
        this.deanonymService = deanonymService;
    }

    @GetMapping("")
    public List<KiteuserDto> listAll() {
        return deanonymService.listAll();
    }
    @GetMapping("/{code}")
    public KiteuserDto deanon(@PathVariable String code) {
        return deanonymService.deAnonymize(code);
    }


}
