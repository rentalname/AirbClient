package liberr.net.airbclient.model

import com.squareup.moshi.Json

data class SearchResult(
        @Json(name = "pricing_quote")
        val pricingQuote: PricingQuote,
        val listing: Listing
)
