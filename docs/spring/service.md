# service



一、引入Maven依赖

spring 项目
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
</dependency>
```
非spring项目

```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>2.15.0</version>
</dependency>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-inline</artifactId>
    <version>2.15.0</version>
</dependency>
```

二、配置

在示例中，我们针对AccountService及AccountDao进行单元测试。
AccountService的调用依赖于AccountDao

1. MockitoJUnitRunner class

MockitoJUnitRunner类自动初始化所​​有使用@Mock和@InjectMocks注释注释的对象。

```java

```

2. MockitoAnnotations.initMocks() method
如果我们不使用MockitoJUnitRunner类方法，那么我们可以使用静态方法MockitoAnnotations.initMocks（）。
在初始化junit测试时，此方法也初始化模拟对象。

```java

```
3. @Mock vs @InjectMocks
@Mock注释为其注释的类创建模拟实现。
@InjectMocks还创建了模拟实现，另外注入了用注释@Mock标记的依赖模拟。

在上面的示例中，我们使用@InjectMocks注释了AccountService类，因此mockito将为AccountService类创建模拟对象，并将AccountDao的模拟依赖项注入其中。

三、 JUnit tests using Mockito


1.model layer class

```java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String userName;
    private String nickName;
    private String phoneNumber;
    private String password;
    private String mail;
    private LocalDateTime activeTime;
    private LocalDateTime registerTime;
    private Boolean lock;
}

```
2.Dao layer class
```java
@Repository
public interface AccountDao extends PagingAndSortingRepository<Account,Integer> {
}
```
3.Service layer class
```java
import cn.boommanpro.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 * @description  Account业务 大致包含Account增加 删除 修改 查询
 */
public interface AccountService {
    /**
     * 查询所有用户
     * @param page 分页参数
     * @return Page<Account>
     */
    Page<Account> queryAll(PageRequest page);

    Account save(Account account);
}
```
4.Service layer tests
```java
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
```

4.Spring boot mockito example – conclusion
## 写在末尾

本文主要翻译自:[Spring boot, mockito and junit – unit test service layer](https://howtodoinjava.com/spring-boot2/spring-boot-mockito-junit-example/)

