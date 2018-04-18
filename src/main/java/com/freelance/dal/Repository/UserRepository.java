package com.freelance.dal.Repository;

import com.freelance.dal.Entity.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

@Repository
public interface UserRepository extends CrudRepository<MyUser, Long> {
    public MyUser findByEmailAndPassword(String email, String password);
    public MyUser findByUserNameAndPassword(String username, String password);
    public MyUser findByEmail(String username);
}
