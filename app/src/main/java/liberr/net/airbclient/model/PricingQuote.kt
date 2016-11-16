package liberr.net.airbclient.model

import com.squareup.moshi.Json

data class PricingQuote(
        @Json(name = "listing_currency")
        val listingCurrency: String,
        @Json(name = "localized_currency")
        val localizedCurrency: String,
        @Json(name = "localized_night_price")
        val localizedNightlyPrice: Int,
        @Json(name = "night_price")
        val nightlyPrice: Int,
        val available: Boolean,
        val checkin: Any,
        val checkout: Any,
        val guests: Int
)
