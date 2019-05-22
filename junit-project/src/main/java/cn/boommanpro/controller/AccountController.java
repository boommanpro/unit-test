package cn.boommanpro.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.common.PageDomain;
import cn.boommanpro.common.PageDto;
import cn.boommanpro.dto.AccountForm;
import cn.boommanpro.model.Account;
import cn.boommanpro.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@RestController
@RequestMapping("account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }



    @GetMapping("queryAll")
    public CallResult queryAll(PageDomain page){
        Page<Account> accountPage = accountService.queryAll(PageRequest.of(page.getPage(), page.getSize()));
        return CallResult.success(new PageDto<>(accountPage));
    }

    @PostMapping("save")
    public CallResult save(AccountForm accountForm) {
        return CallResult.success(accountService.save(accountForm.convertToAccount()));
    }

    @PostMapping("delete")
    public CallResult delete(@RequestParam Integer accountId) {

        return CallResult.success(accountService.delete(accountId));
    }

    @PostMapping("update")
    public CallResult update(Account account) {
        return CallResult.success(accountService.update(account));
    }

}
