package lat.pam.burger

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderFragment : Fragment() {

    private lateinit var rvOrders: RecyclerView
    private lateinit var tvEmptyOrder: LinearLayout
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("OrderFragment", "onCreateView started")
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("OrderFragment", "onViewCreated started")

        rvOrders = view.findViewById(R.id.rvOrders)
        tvEmptyOrder = view.findViewById(R.id.tvEmptyOrder)

        setupRecyclerView()
        loadOrders()
    }

    override fun onResume() {
        super.onResume()
        loadOrders()
    }

    private fun setupRecyclerView() {
        rvOrders.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadOrders() {
        val orders = OrderManager.getAllOrders()
        Log.d("OrderFragment", "Total orders: ${orders.size}")

        if (orders.isEmpty()) {
            rvOrders.visibility = View.GONE
            tvEmptyOrder.visibility = View.VISIBLE
        } else {
            rvOrders.visibility = View.VISIBLE
            tvEmptyOrder.visibility = View.GONE

            orderAdapter = OrderAdapter(orders)
            rvOrders.adapter = orderAdapter
        }
    }
}