package cn.boommanpro.dto;

import cn.boommanpro.common.BeanUtils;
import cn.boommanpro.common.DTOConvert;
import cn.boommanpro.model.Account;
import lombok.Data;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Data
public class AccountForm {

    private String userName;
    private String nickName;
    private String phoneNumber;
    private String password;
    private String mail;


    public Account convertToAccount() {
        AccountFormConvert userInputDTOConvert = new AccountFormConvert();
        return userInputDTOConvert.convert(this);
    }

    private static class AccountFormConvert implements DTOConvert<AccountForm, Account> {
        @Override
        public Account convert(AccountForm accountForm) {
            Account account = new Account();
            BeanUtils.copyProperties(accountForm, account);
            return account;
        }
    }

}
