package liberr.net.airbclient.view

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import liberr.net.airbclient.R
import liberr.net.airbclient.model.Listing


class ListingView : FrameLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    var roomImageView: ImageView
    var roomIdView: TextView
    var roomNameView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_listing, this)
        roomImageView = findViewById(R.id.roomImage) as ImageView
        roomIdView = findViewById(R.id.roomId) as TextView
        roomNameView = findViewById(R.id.roomName) as TextView
    }

    fun setListing(item: Listing) {
        roomIdView.text = item.id.toString()
        roomImageView.setImageURI(Uri.parse(item.pictureUrl))
        roomNameView.text = item.name
    }
}
