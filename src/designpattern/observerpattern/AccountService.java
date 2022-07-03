package designpattern.observerpattern;


/*
https://gpcoder.com/4747-huong-dan-java-design-pattern-observer/
 */


import java.util.ArrayList;
import java.util.List;

public class AccountService implements Subject {

    enum LoginStatus {
        SUCCESS, FAILURE, INVALID, EXPIRED
    }

    private User user;
    private List<Observer> observers = new ArrayList<>();

    public AccountService(String email, String ip) {
        user = new User();
        user.setEmail(email);
        user.setIp(ip);
    }

    public void logIn() {
        if (isValidIP()) {
            user.setStatus(LoginStatus.SUCCESS);
        } else {
            user.setStatus(LoginStatus.FAILURE);
        }
    }

    public void changeStatus( LoginStatus status) {
        user.setStatus(status);
        System.out.println("status change " + status);
        this.notifyAllObserver();
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(user);
        }
    }

    private boolean isValidIP() {
        return "127.0.0.1".equals(user.getIp());
    }
}
