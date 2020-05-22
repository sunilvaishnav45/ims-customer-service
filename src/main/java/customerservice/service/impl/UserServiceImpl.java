package customerservice.service.impl;

import customerservice.entity.User;
import customerservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Override
    public User getLoggedInUser() {
        //TODO : Update your logic here
        return null;
    }

    @Override
    public boolean userHasReadPermission(User user) {
        //TODO : Update your logic here
        return true;
    }

    @Override
    public boolean userHasWritePermission(User user) {
        //TODO : Update your logic here
        return true;
    }
}