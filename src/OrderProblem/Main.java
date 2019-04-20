package OrderProblem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderManager om = new OrderManager(10);
        for(int i =1 ; i <= 100; i++){
            om.recordOrder(new Order(i));
        }

        System.out.println(om.getOrderFromLastIndex(5).orderID);
    }

}


