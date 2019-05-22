package cn.boommanpro.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Data
@Entity
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
