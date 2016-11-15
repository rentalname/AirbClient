package liberr.net.airbclient

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import liberr.net.airbclient.model.Listing
import liberr.net.airbclient.view.ListingView


class ListingListAdapter(private val context: Context) : BaseAdapter() {

    var listings: List<Listing> = emptyList()

    override fun getItem(n: Int): Listing = listings.get(n)

    override fun getItemId(_n: Int): Long = 0L

    override fun getCount(): Int = listings.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return ((convertView as? ListingView) ?: ListingView(context)).apply {
            setListing(getItem(position))
        }
    }

}