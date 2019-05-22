package cn.boommanpro.service.impl;

import cn.boommanpro.dao.AccountDao;
import cn.boommanpro.model.Account;
import cn.boommanpro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author BoomManPro
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Page<Account> queryAll(PageRequest page) {
        return accountDao.findAll(page);
    }

    @Override
    public Account save(Account account) {
        LocalDateTime now = LocalDateTime.now();
        account.setRegisterTime(now);
        account.setActiveTime(now);
        return accountDao.save(account);
    }

    @Override
    public Integer delete(Integer accountId) {
        accountDao.deleteById(accountId);
        return accountId;
    }

    @Override
    public Account update(Account account) {
        return accountDao.save(account);
    }
}
