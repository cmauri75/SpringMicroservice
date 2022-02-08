package eu.unicredit.kite.docker_microservices.service.entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Kiteuser {
    @Id
    @NonNull private String code;
    private String name;
    private String surname;
    private String companyName;
    @NonNull private boolean isCompany;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Kiteuser kiteuser = (Kiteuser) o;
        return code != null && Objects.equals(code, kiteuser.code);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
