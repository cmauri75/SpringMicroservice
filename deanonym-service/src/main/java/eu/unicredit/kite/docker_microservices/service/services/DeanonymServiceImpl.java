package eu.unicredit.kite.docker_microservices.service.services;

import eu.unicredit.kite.docker_microservices.service.dao.KiteuserDao;
import eu.unicredit.kite.docker_microservices.service.dtos.KiteuserDto;
import eu.unicredit.kite.docker_microservices.service.entities.Kiteuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeanonymServiceImpl implements DeanonymService {

    private final KiteuserDao userDao;

    @Autowired
    public DeanonymServiceImpl(KiteuserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<KiteuserDto> listAll() {
        return userDao
                .findAll()
                .stream()
                .map(DeanonymServiceImpl::User2Dto)
                .collect(Collectors.toList());

    }

    @Override
    public KiteuserDto deAnonymize(String code) {
        Optional<Kiteuser> u =  userDao.findById(code);
        return u.isPresent()?User2Dto(u.get()):null;
    }

    private static KiteuserDto User2Dto(Kiteuser user) {
        return KiteuserDto
                .builder()
                .code(user.getCode())
                .name(user.getName())
                .surname(user.getSurname())
                .companyName(user.getCompanyName())
                .isCompany(user.isCompany())
                .build();
    }


}
