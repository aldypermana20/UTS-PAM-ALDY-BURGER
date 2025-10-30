package lat.pam.burger

object OrderManager {
    private val orderList = mutableListOf<Order>()

    fun addOrder(order: Order) {
        orderList.add(order)
    }

    fun getAllOrders(): List<Order> {
        return orderList
    }

    fun clearAllOrders() {
        orderList.clear()
    }
}