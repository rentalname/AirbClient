package liberr.net.airbclient.model

data class PricingQuote(
        val available: Boolean,
        val checkin: Any,
        val checkout: Any,
        val guests: Int,
        val listingCurrency: String,
        val localizedCurrency: String,
        val localizedNightlyPrice: Int,
        val localizedServiceFee: Int,
        val localizedTotalPrice: Int,
        val nightlyPrice: Int,
        val serviceFee: Int,
        val totalPrice: Int
)
