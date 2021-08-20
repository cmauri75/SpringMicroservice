package eu.unicredit.kite.docker_microservices.service.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kiteuser {
    @Id
    @NonNull private String code;
    private String name;
    private String surname;
    private String companyName;
    @NonNull private boolean isCompany;

    public static Kiteuser createCompany(String code, String companyName) {
        return new Kiteuser(code, null,null,companyName,true);
    }

    public static Kiteuser createPerson(String code, String name, String surname) {
        return new Kiteuser(code, name,surname,null,false);
    }

}
