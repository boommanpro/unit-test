package cn.boommanpro.service;

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

    Integer delete(Integer accountId);

    Account update(Account account);
}
