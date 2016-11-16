package liberr.net.airbclient

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.orhanobut.logger.Logger
import com.squareup.moshi.Moshi
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import liberr.net.airbclient.client.AirbnbClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listing_list = findViewById(R.id.listing_list) as ListView
        val listingListAdapter = ListingListAdapter(applicationContext)
        listing_list.adapter = listingListAdapter
        listing_list.setOnItemClickListener { adapterView, view, i, l ->
            applicationContext.toast("TAP!")
        }

        val moshi = Moshi.Builder().build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.airbnb.com/v2/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        val apiClient = retrofit.create(AirbnbClient::class.java)

        apiClient.searchResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindToLifecycle(listing_list)
                .subscribe({ searchResponse ->
                    listingListAdapter.listings = searchResponse.searchResults.map({it.listing})
                    listingListAdapter.notifyDataSetChanged()
                }, {
                    Logger.d(it)
                    toast("エラー: $it", Toast.LENGTH_LONG)
                })

    }

}
