package edu.iu.spmflora.flowershop.repository;

import edu.iu.spmflora.flowershop.model.Flower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowersRepository
        extends CrudRepository<Flower, Integer> {
}
