package com.freelance.dal.Repository;

import com.freelance.dal.Entity.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<MyUser, Long> {
    public MyUser findByEmailAndPassword(String email, String password);
    public MyUser findByUserNameAndPassword(String username, String password);
    public MyUser findByUserName(String username);
    public MyUser findByEmail(String username);
    public MyUser findById(Long id);
    public List<MyUser> findAll();
//    public MyUser findByEmailOrUserName(String username);
}
