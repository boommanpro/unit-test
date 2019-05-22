package cn.boommanpro.dao;


import cn.boommanpro.model.Account;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountDaoTest {

    @Autowired
    private AccountDao accountDao;

    private Account account;

    @Before
    public void beforeSet() {
        account = Account.builder()
                .accountId(1)
                .userName("wangqimeng").nickName("BoomManPro")
                .password("xxxx").mail("boommanpro@gmai.com").activeTime(LocalDateTime.now())
                .registerTime(LocalDateTime.now()).build();
    }

    @Test
    public void save() {
        Account save = accountDao.save(account);
        TestCase.assertEquals(save.getAccountId(), account.getAccountId());
    }

    @Test

    public void findAll() {
        Account save = accountDao.save(account);
        Page<Account> all = accountDao.findAll(PageRequest.of(0, 10));
        TestCase.assertEquals(all.getContent().size(), 1);
    }

    @Test
    public void update() {
        Account save = accountDao.save(account);
        save.setNickName("BoomMan");
        accountDao.save(save);
        Iterable<Account> all = accountDao.findAll();
        Optional<Account> byId = accountDao.findById(save.getAccountId());
        TestCase.assertEquals(byId.get().getNickName(), "BoomMan");
    }

    @Test
    public void test3_delete() {
        Account save = accountDao.save(account);
        accountDao.deleteById(save.getAccountId());
        Page<Account> all = accountDao.findAll(PageRequest.of(0, 10));
        TestCase.assertEquals(all.getContent().size(), 0);
    }


}
