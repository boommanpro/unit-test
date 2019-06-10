package cn.boommanpro.service;

import cn.boommanpro.dao.AccountDao;
import cn.boommanpro.model.Account;
import cn.boommanpro.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @date 2019/6/4 10:55
 * @created by BoomManPro
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    AccountDao accountDao;

    private Account account;

    @Before
    public void beforeSet(){
        account = Account.builder()
                .accountId(1)
                .userName("wangqimeng").nickName("BoomManPro")
                .password("xxxx").mail("boommanpro@gmai.com").activeTime(LocalDateTime.now())
                .registerTime(LocalDateTime.now()).build();
    }


    @Test
    public void queryAll() {

        PageRequest page = PageRequest.of(0, 10);
        Page<Account> list = new Page<Account>() {
            @Override
            public int getTotalPages() {
                return 0;
            }

            @Override
            public long getTotalElements() {
                return 0;
            }

            @Override
            public <U> Page<U> map(Function<? super Account, ? extends U> converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<Account> getContent() {
                return null;
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<Account> iterator() {
                return null;
            }
        };


        when(accountDao.findAll(page)).thenReturn(list);

        //test
        Page<Account> accounts = accountService.queryAll(page);

        assertEquals(0, accounts.getNumber());
        verify(accountDao, times(1)).findAll(page);
    }

    @Test
    public void save() {

        when(accountDao.save(account)).thenReturn(account);

        Account result = accountService.save(account);
        assertEquals("wangqimeng", result.getUserName());
        verify(accountDao, times(1)).save(account);
    }


}
