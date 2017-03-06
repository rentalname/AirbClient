package liberr.net.airbclient

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.orhanobut.logger.Logger
import com.squareup.moshi.Moshi
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import liberr.net.airbclient.MapsFragment.OnChangeMapPositionListener
import liberr.net.airbclient.MapsFragment.OnFragmentInteractionListener
import liberr.net.airbclient.client.AirbnbClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : Activity(), OnFragmentInteractionListener, OnChangeMapPositionListener {
    override fun onFragmentInteraction(uri: Uri) {}

    override fun onChangeMapPosition(lat: Double, lng: Double) {
        updateListingList(lat, lng)
    }

    private var listingListAdapter: ListingListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listing_list = findViewById(R.id.listing_list) as ListView
        listingListAdapter = ListingListAdapter(applicationContext)
        listing_list.adapter = listingListAdapter
        listing_list.setOnItemClickListener { adapterView, view, i, l ->
            applicationContext.toast("TAP!")
        }
        updateListingList(MapsFragment.Home.latitude, MapsFragment.Home.longitude)
    }

    private fun updateListingList(lat: Double, lng: Double) {
        val listing_list = findViewById(R.id.listing_list) as ListView
        val moshi = Moshi.Builder().build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.airbnb.com/v2/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        val apiClient = retrofit.create(AirbnbClient::class.java)

        apiClient.searchResultWithLatLng(lat, lng)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindToLifecycle(listing_list)
                .subscribe({ searchResponse ->
                    (listingListAdapter as ListingListAdapter).listings = searchResponse.searchResults.map({ it.listing })
                    (listingListAdapter as ListingListAdapter).notifyDataSetChanged()
                }, {
                    Logger.d(it)
                    toast("エラー: $it", Toast.LENGTH_LONG)
                })
    }
}
