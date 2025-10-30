package lat.pam.burger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(
    private val foodList: List<Food>,
    private val onItemClick: (Food) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardFood: CardView = itemView.findViewById(R.id.card_food)
        val ivFoodImage: ImageView = itemView.findViewById(R.id.img_food)
        val tvFoodName: TextView = itemView.findViewById(R.id.tv_food_name)
        val tvFoodPrice: TextView = itemView.findViewById(R.id.tv_food_price)
        val tvFoodDescription: TextView = itemView.findViewById(R.id.tv_food_desc)

        fun bind(food: Food) {
            ivFoodImage.setImageResource(food.imageResId)
            tvFoodName.text = food.name
            tvFoodDescription.text = food.description
            tvFoodPrice.text = food.price

            cardFood.setOnClickListener {
                onItemClick(food)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size
}