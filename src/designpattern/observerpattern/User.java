package designpattern.observerpattern;

public class User {
    private String email;
    private String ip;
    private AccountService.LoginStatus status;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setStatus(AccountService.LoginStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public String getIp() {
        return ip;
    }

    public AccountService.LoginStatus getStatus() {
        return status;
    }
}
