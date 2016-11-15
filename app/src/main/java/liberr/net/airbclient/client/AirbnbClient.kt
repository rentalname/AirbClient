package liberr.net.airbclient.client

import liberr.net.airbclient.model.Listing
import liberr.net.airbclient.model.SearchResult
import retrofit2.http.GET
import rx.Observable

/**
 * @see http://airbnbapi.org/
 */

interface AirbnbClient {
    @GET("search_results?client_id=3092nxybyb0otqw18e8nh5nty")
    fun searchResult(): Observable<SearchResult>
}

