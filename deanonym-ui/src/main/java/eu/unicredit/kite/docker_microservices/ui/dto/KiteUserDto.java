package eu.unicredit.kite.docker_microservices.ui.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KiteUserDto {
    private String code;
    private String name;
    private String surname;
    private String companyName;
    private boolean isCompany;
}
