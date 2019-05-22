package cn.boommanpro.dao;

import cn.boommanpro.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends PagingAndSortingRepository<Account,Integer> {
}
