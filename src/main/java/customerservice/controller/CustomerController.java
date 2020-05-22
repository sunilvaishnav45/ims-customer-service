package customerservice.controller;

import customerservice.entity.Customer;
import customerservice.entity.User;
import customerservice.service.CustomerService;
import customerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cust")
public class CustomerController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(value = "ids" , required = false) String ids){
        Optional<List<Customer>> customers = null;
        User loggedInUser = userService.getLoggedInUser();
        if(!userService.userHasReadPermission(loggedInUser)){
            return new ResponseEntity("User doesn't have read permission",HttpStatus.BAD_REQUEST);
        }
        customers = customerService.getCustomers(ids);
        if(!customers.isPresent())
            return new ResponseEntity("No record found",HttpStatus.BAD_REQUEST);
        return new ResponseEntity(customers.get(),HttpStatus.ACCEPTED);
    }
}
