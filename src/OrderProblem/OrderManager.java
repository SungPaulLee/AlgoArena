package OrderProblem;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {

    public static void main(String[] args) {

    }
    private int sizeOfOrderReservoir = 0;
    private Map<Integer,Order> orderMap = new HashMap<Integer, Order>();
    private int lastInsertedOrderId = 0;

    public OrderManager(int size)
    {
        this.sizeOfOrderReservoir = size;
    }

    public void recordOrder(Order order)
    {
        Integer orderId = order.getOrderId();
        if(orderMap.size() == sizeOfOrderReservoir)
        {
            orderMap.remove( orderId - sizeOfOrderReservoir);
        }
        orderMap.put(orderId, order);
        lastInsertedOrderId = orderId;
    }

    public Order getOrderFromLastIndex(int indexFromLast)
    {
        return orderMap.get(lastInsertedOrderId - indexFromLast + 1);
    }
}
