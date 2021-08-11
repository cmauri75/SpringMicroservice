package eu.unicredit.kite.docker_microservices.service.services;

import eu.unicredit.kite.docker_microservices.service.dtos.KiteUserDto;
import eu.unicredit.kite.docker_microservices.service.entities.KiteUser;

import java.util.List;
import java.util.Optional;

public interface DeanonymService {

    List<KiteUserDto> listAll();

    KiteUserDto deAnonymize(String code);
}
