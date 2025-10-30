package lat.pam.burger

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BurgerAdapter(
    private val burgerList: List<Burger>
) : RecyclerView.Adapter<BurgerAdapter.BurgerViewHolder>() {

    class BurgerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBurger: ImageView = itemView.findViewById(R.id.img_food)
        val tvBurgerName: TextView = itemView.findViewById(R.id.tv_food_name)
        val tvBurgerDesc: TextView = itemView.findViewById(R.id.tv_food_desc)
        val tvBurgerPrice: TextView = itemView.findViewById(R.id.tv_food_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return BurgerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BurgerViewHolder, position: Int) {
        val burger = burgerList[position]

        holder.imgBurger.setImageResource(burger.imageResId)
        holder.tvBurgerName.text = burger.name
        holder.tvBurgerDesc.text = burger.description
        holder.tvBurgerPrice.text = burger.price

        // Handle item click
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, FoodDetailActivity::class.java)

            // Kirim data burger ke FoodDetailActivity
            intent.putExtra("FOOD_NAME", burger.name)
            intent.putExtra("FOOD_DESCRIPTION", burger.description)
            intent.putExtra("FOOD_PRICE", burger.price)
            intent.putExtra("FOOD_IMAGE", burger.imageResId)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = burgerList.size
}