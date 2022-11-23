package kim.blog.admin.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    String account;
    String password;

    public Admin(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
