package cn.boommanpro.model;

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
