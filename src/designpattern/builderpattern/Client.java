package designpattern.builderpattern;

public class Client {
    public static void main(String[] args) {
        Order order = new FastFoodOrderBuilder()
                .orderType(OrderType.ON_SITE).orderBread(BreadType.OMELETTE)
                .orderSauce(SauceType.SOY_SAUCE).build();
        System.out.println(order);

        BankAccount newAccount = new BankAccount.BankAccountBuilder("GP Coder", "0123456789")
                .withEmail("contact@gpcoder.com")
                .wantNewsletter(true)
                .build();
        System.out.println(newAccount);
    }
}
