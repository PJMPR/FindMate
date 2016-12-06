package dao;

import domain.model.Account;

import java.util.List;

/**
 * Created by Mela on 2016-12-06.
 */
public interface IAccountRepository extends IRepository<Account> {
        public List<Account> withUserName(String userName);
}
