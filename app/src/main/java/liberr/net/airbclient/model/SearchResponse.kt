package liberr.net.airbclient.model

import com.squareup.moshi.Json

data class SearchResponse (
        @Json(name = "search_results")
        val searchResults : List<SearchResult>
)