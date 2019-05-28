package srv.auth.dao;


import org.springframework.stereotype.Repository;
import srv.auth.annotation.ValueInc;
import srv.auth.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Repository(value = "accountDao")
public class AccountDaoImpl extends GenericaDaoImpl<Account> implements AccountDao {

    private String ACCOUNT_USER_ID_SEQ_QUERY = "select nextval('srv_auth.\"user_id_seq\"');";

    public void beanInit() {
        this.setClazz(Account.class);
    }

    // find account by 'login' and 'password'
    public Account findByLogin(String login) {

        Map<String, Object> params = new HashMap<>();
        params.put("login", login);

        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Account account = entityManager.find(Account.class, params);
        entityManager.getTransaction().commit();
        entityManager.close();
        return account;
    }

    @Override
    public Account create(Account account) {
        try {
            setAccountUserId(account);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.create(account);
    }


    private Long getIncrementedValue() {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery(ACCOUNT_USER_ID_SEQ_QUERY);
        Long incValue = ((BigInteger)query.getSingleResult()).longValue();
        entityManager.getTransaction().commit();
        entityManager.close();
        return  incValue;
    }

    private void setAccountUserId(Account account) throws IllegalAccessException {

        for (Field field : account.getClass().getDeclaredFields()) {

            Annotation annotation = field.getAnnotation(ValueInc.class);
            if (annotation != null) {

                long startValue = ((ValueInc)annotation).startvalue();

                long incValue = getIncrementedValue();

                field.setAccessible(true);
                field.set(account, startValue + incValue);
            }

        }
    }
}
