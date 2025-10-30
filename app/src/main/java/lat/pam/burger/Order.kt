package lat.pam.burger

data class Order(
    val foodName: String,
    val foodPrice: String,
    val servings: String,
    val orderingName: String,
    val address: String,
    val foodImage: Int,
    val orderTime: String = java.text.SimpleDateFormat("dd MMM yyyy, HH:mm", java.util.Locale.getDefault()).format(java.util.Date())
)