package eu.unicredit.kite.docker_microservices.service.services;

import eu.unicredit.kite.docker_microservices.service.dtos.KiteuserDto;

import java.util.List;

public interface DeanonymService {

    List<KiteuserDto> listAll();

    KiteuserDto deAnonymize(String code);
}
