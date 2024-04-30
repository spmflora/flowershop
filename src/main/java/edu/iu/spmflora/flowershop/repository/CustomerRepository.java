package edu.iu.spmflora.flowershop.repository;

import edu.iu.spmflora.flowershop.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer, String> {
    Customer findByUsername(String username);

}
