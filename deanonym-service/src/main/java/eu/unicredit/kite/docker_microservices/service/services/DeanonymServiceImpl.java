package eu.unicredit.kite.docker_microservices.service.services;

import eu.unicredit.kite.docker_microservices.service.dao.KiteUserDao;
import eu.unicredit.kite.docker_microservices.service.dtos.KiteUserDto;
import eu.unicredit.kite.docker_microservices.service.entities.KiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeanonymServiceImpl implements DeanonymService {

    private final KiteUserDao userDao;

    @Autowired
    public DeanonymServiceImpl(KiteUserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<KiteUserDto> listAll() {
        return userDao
                .findAll()
                .stream()
                .map(DeanonymServiceImpl::User2Dto)
                .collect(Collectors.toList());

    }

    @Override
    public KiteUserDto deAnonymize(String code) {
        Optional<KiteUser> u =  userDao.findById(code);
        return u.isPresent()?User2Dto(u.get()):null;
    }

    private static KiteUserDto User2Dto(KiteUser user) {
        return KiteUserDto
                .builder()
                .code(user.getCode())
                .name(user.getName())
                .surname(user.getSurname())
                .companyName(user.getCompanyName())
                .isCompany(user.isCompany())
                .build();
    }


}
