package com.freelance.dal.Repository;

import com.freelance.dal.Entity.Bids;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BidsRepository extends CrudRepository<Bids, Long> {
    public List<Bids> findAll();
    public List<Bids> findAllByProject(Long id);
}
