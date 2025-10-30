package lat.pam.burger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recyclerViewBurger: RecyclerView
    private lateinit var burgerAdapter: BurgerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewBurger = view.findViewById(R.id.recyclerViewBurger)
        recyclerViewBurger.layoutManager = LinearLayoutManager(requireContext())

        val burgerList = listOf(
            Burger("Burger Classic", "Daging sapi, keju, selada, dan tomat segar", "Rp 25.000", R.drawable.burger1),
            Burger("Cheese Burger", "Burger dengan lapisan keju leleh", "Rp 30.000", R.drawable.burger2),
            Burger("Double Beef Burger", "Dua lapis daging sapi juicy dan saus spesial", "Rp 40.000", R.drawable.burger3),
            Burger("Spicy Chicken Burger", "Ayam goreng pedas dengan saus sambal spesial", "Rp 35.000", R.drawable.burger4),
            Burger("BBQ Beef Burger", "Daging sapi panggang dengan saus BBQ smokey", "Rp 45.000", R.drawable.burger5),
            Burger("Mushroom Swiss Burger", "Jamur tumis dengan keju Swiss leleh", "Rp 38.000", R.drawable.burger6),
            Burger("Bacon Cheeseburger", "Double beef dengan bacon crispy dan keju cheddar", "Rp 48.000", R.drawable.burger7),
            Burger("Fish Fillet Burger", "Fillet ikan dori crispy dengan tartar sauce", "Rp 32.000", R.drawable.burger8),
            Burger("Veggie Burger", "Patty sayuran dengan alpukat dan hummus", "Rp 28.000", R.drawable.burger9),
            Burger("Triple Cheese Burger", "Tiga jenis keju mozzarella, cheddar, dan blue cheese", "Rp 42.000", R.drawable.burger10),
            Burger("Teriyaki Burger", "Daging dengan saus teriyaki manis dan nanas", "Rp 40.000", R.drawable.burger11),
            Burger("Egg Burger", "Telur mata sapi, keju, dan hash brown", "Rp 30.000", R.drawable.burger12),
            Burger("Monster Burger", "Triple patty dengan semua topping lengkap", "Rp 55.000", R.drawable.burger13)
        )

        burgerAdapter = BurgerAdapter(burgerList)
        recyclerViewBurger.adapter = burgerAdapter
    }
}