package liberr.net.airbclient.client

import liberr.net.airbclient.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * @see http://airbnbapi.org/
 */

interface AirbnbClient {
    @GET("search_results?client_id=3092nxybyb0otqw18e8nh5nty")
    fun searchResult(): Observable<SearchResponse>

    @GET("search_results?client_id=3092nxybyb0otqw18e8nh5nty")
    fun searchResultWithLatLng(@Query("lat") lat: Double, @Query("lng") lng: Double): Observable<SearchResponse>
}

