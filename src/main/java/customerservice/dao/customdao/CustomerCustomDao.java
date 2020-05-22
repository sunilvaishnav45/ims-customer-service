package customerservice.dao.customdao;

import customerservice.entity.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerCustomDao {

    @Autowired
    private EntityManager entityManager;

    public Session getSession(){
        return  entityManager.unwrap(Session.class);
    }

    public Optional<List<Customer>> getCustomers(String commaSepratedIds){
        List<Customer> customers = null;
        String sqlQuery = "select * from customer";
        if(commaSepratedIds!=null && !commaSepratedIds.isEmpty()){
            sqlQuery = sqlQuery+" where id IN (?) ";
        }
        Query query = entityManager.createNativeQuery(sqlQuery,Customer.class);
        if(commaSepratedIds!=null && !commaSepratedIds.isEmpty()){
            query.setParameter(1,commaSepratedIds);
        }
        customers = query.getResultList();
        return Optional.ofNullable(customers);
    }
}
