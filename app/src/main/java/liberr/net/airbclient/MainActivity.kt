package liberr.net.airbclient

import android.app.Activity
import android.os.Bundle
import android.widget.ListView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listing_list = findViewById(R.id.listing_list) as ListView
        val listingListAdapter = ListingListAdapter(applicationContext)
        listing_list.adapter = listingListAdapter
        listing_list.setOnItemClickListener { adapterView, view, i, l ->

        }
    }
}
