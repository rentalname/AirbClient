package liberr.net.airbclient.model

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class PricingQuote(
        @Json(name = "listing_currency")
        val listingCurrency: String,
        @Json(name = "localized_currency")
        val localizedCurrency: String,
        @Json(name = "localized_night_price")
        val localizedNightlyPrice: Int,
        @Json(name = "night_price")
        val nightlyPrice: Int,
        val available: Boolean,
        val checkin: String,
        val checkout: String,
        val guests: Int
) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<PricingQuote> = object : Parcelable.Creator<PricingQuote> {
            override fun createFromParcel(source: Parcel): PricingQuote = PricingQuote(source)
            override fun newArray(size: Int): Array<PricingQuote?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readInt(), source.readInt(), 1.equals(source.readInt()), source.readString(), source.readString(), source.readInt())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(listingCurrency)
        dest?.writeString(localizedCurrency)
        dest?.writeInt(localizedNightlyPrice)
        dest?.writeInt(nightlyPrice)
        dest?.writeInt((if (available) 1 else 0))
        dest?.writeString(checkin)
        dest?.writeString(checkout)
        dest?.writeInt(guests)
    }
}
