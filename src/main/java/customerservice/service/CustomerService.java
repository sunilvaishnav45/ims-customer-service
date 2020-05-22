package customerservice.service;

import customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public Optional<List<Customer>> getCustomers(String commaSepratedIds);
}
