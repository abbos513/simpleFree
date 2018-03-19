package com.freelance.dal.Repository;

import com.freelance.dal.Entity.SignUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends CrudRepository<SignUp, Long>{

    public SignUp findAllByHashCode(String hashcode);
    public SignUp findAllByEmail(String email);

}
