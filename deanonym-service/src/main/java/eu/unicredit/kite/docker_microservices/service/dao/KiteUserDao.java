package eu.unicredit.kite.docker_microservices.service.dao;

import eu.unicredit.kite.docker_microservices.service.entities.KiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KiteUserDao extends JpaRepository<KiteUser, String> {
}
