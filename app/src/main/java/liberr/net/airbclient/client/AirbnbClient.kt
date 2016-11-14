package liberr.net.airbclient.client

import liberr.net.airbclient.model.SearchResult
import retrofit2.http.GET
import rx.Observable

/**
 * Created by hash on 2016/11/10.
 */

interface AirbnbClient {
    @GET("/listings")
    fun listings(): Observable<Array<SearchResult>>
}

