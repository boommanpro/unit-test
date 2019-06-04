package cn.boommanpro.controller;

import cn.boommanpro.model.Account;
import cn.boommanpro.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @date 2019/6/4 10:56
 * @created by BoomManPro
 */
@WebMvcTest
@RunWith(SpringRunner.class)
public class AccountControllerTest {

    private static final String PREFIX = "/account";


    @Autowired
    MockMvc mockMvc;
    @MockBean
    AccountService accountService;

    @Before
    public void setUp() throws Exception {
        Account account = accountService.save(new Account(1, "wangqimeng", "boomamnpro", "1573510xxxx",
                "xxxxx", "boommanpro@gmail.com", LocalDateTime.now(), LocalDateTime.now(), Boolean.FALSE));
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        Page<Account> accountPage = new Page<Account>() {
            @Override
            public int getTotalPages() {
                return 1;
            }

            @Override
            public long getTotalElements() {
                return 1;
            }

            @Override
            public <U> Page<U> map(Function<? super Account, ? extends U> converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return 1;
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
                return accountList;
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
                return accountList.iterator();
            }
        };

        Mockito.when(accountService.queryAll(PageRequest.of(1, 10))).
                thenReturn(accountPage);


        Mockito.when(accountService.save(account)).
                thenReturn(account);


        Mockito.when(accountService.delete(1)).
                thenReturn(1);

        Mockito.when(accountService.update(account)).
                thenReturn(account);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryAll() {

    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post(PREFIX+"/delete"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
    }
}