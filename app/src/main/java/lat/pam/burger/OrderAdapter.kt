package lat.pam.burger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivOrderFood: ImageView = view.findViewById(R.id.ivOrderFood)
        val tvOrderFoodName: TextView = view.findViewById(R.id.tvOrderFoodName)
        val tvOrderServings: TextView = view.findViewById(R.id.tvOrderServings)
        val tvOrderPrice: TextView = view.findViewById(R.id.tvOrderPrice)
        val tvOrderName: TextView = view.findViewById(R.id.tvOrderName)
        val tvOrderAddress: TextView = view.findViewById(R.id.tvOrderAddress)
        val tvOrderTime: TextView = view.findViewById(R.id.tvOrderTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]

        holder.ivOrderFood.setImageResource(order.foodImage)
        holder.tvOrderFoodName.text = order.foodName
        holder.tvOrderServings.text = "${order.servings} porsi"
        holder.tvOrderPrice.text = order.foodPrice
        holder.tvOrderName.text = "Pemesan: ${order.orderingName}"
        holder.tvOrderAddress.text = "Alamat: ${order.address}"
        holder.tvOrderTime.text = order.orderTime
    }

    override fun getItemCount(): Int = orders.size
}