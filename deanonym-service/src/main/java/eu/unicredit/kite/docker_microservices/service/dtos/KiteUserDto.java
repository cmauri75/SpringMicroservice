package eu.unicredit.kite.docker_microservices.service.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KiteUserDto {
    private String code;
    private String name;
    private String surname;
    private String companyName;
    private boolean isCompany;
}
