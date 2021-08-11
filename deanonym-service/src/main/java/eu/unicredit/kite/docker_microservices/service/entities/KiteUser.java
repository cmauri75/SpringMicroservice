package eu.unicredit.kite.docker_microservices.service.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KiteUser {
    @Id
    @NonNull private String code;
    private String name;
    private String surname;
    private String companyName;
    @NonNull private boolean isCompany;

    public static KiteUser createCompany(String code, String companyName) {
        return new KiteUser(code, null,null,companyName,true);
    }

    public static KiteUser createPerson(String code, String name, String surname) {
        return new KiteUser(code, name,surname,null,false);
    }

}
