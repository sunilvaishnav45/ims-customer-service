package customerservice.service.impl;

import customerservice.dao.customdao.CustomerCustomDao;
import customerservice.entity.Customer;
import customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerCustomDao customerCustomDao;

    @Override
    public Optional<List<Customer>> getCustomers(String commaSepratedIds) {
        return customerCustomDao.getCustomers(commaSepratedIds);
    }
}
