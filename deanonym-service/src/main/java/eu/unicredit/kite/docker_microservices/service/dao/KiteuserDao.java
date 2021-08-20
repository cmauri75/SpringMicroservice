package eu.unicredit.kite.docker_microservices.service.dao;

import eu.unicredit.kite.docker_microservices.service.entities.Kiteuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KiteuserDao extends JpaRepository<Kiteuser, String> {
}
