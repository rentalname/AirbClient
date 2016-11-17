package liberr.net.airbclient.model

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class Listing(
        @Json(name = "person_capacity")
        val personCapacity: Int,
        @Json(name = "listing_tags")
        val listingTags: List<String>,
        @Json(name = "picture_url")
        val pictureUrl: String,
        @Json(name = "property_type")
        val propertyType: String,
        @Json(name = "property_type_id")
        val propertyTypeId: Int,
        @Json(name = "public_address")
        val publicAddress: String,
        @Json(name = "review_count")
        val reviewsCount: Int,
        @Json(name = "room_type")
        val roomType: String,
        @Json(name = "room_type_category")
        val roomTypeCategory: String,
        @Json(name = "scrime_color")
        val scrimColor: String,
        @Json(name = "star_rating")
        val starRating: Float = 0f,
        @Json(name = "thumbnail_url")
        val thumbnailUrl: String,
        @Json(name = "user_id")
        val userId: Int,
        @Json(name = "xl_picture_url")
        val xlPictureUrl: String,
        @Json(name = "preview_encoded_png")
        val previewEncodedPng: String,
        @Json(name = "picture_urls")
        val pictureUrls: List<String>,
        @Json(name = "xl_picture_urls")
        val xlPictureUrls: List<String>,
        val id: Int,
        val name: String,
        val bathrooms: Int,
        val bedrooms: Int,
        val beds: Int,
        val city: String,
        val distance: Double,
        val lat: Double,
        val lng: Double,
        val neighborhood: String,
        val user: User
) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Listing> = object : Parcelable.Creator<Listing> {
            override fun createFromParcel(source: Parcel): Listing = Listing(source)
            override fun newArray(size: Int): Array<Listing?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readInt(), source.createStringArrayList(), source.readString(), source.readString(), source.readInt(), source.readString(), source.readInt(), source.readString(), source.readString(), source.readString(), source.readFloat(), source.readString(), source.readInt(), source.readString(), source.readString(), source.createStringArrayList(), source.createStringArrayList(), source.readInt(), source.readString(), source.readInt(), source.readInt(), source.readInt(), source.readString(), source.readDouble(), source.readDouble(), source.readDouble(), source.readString(), source.readParcelable<User>(User::class.java.classLoader))

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(personCapacity)
        dest?.writeStringList(listingTags)
        dest?.writeString(pictureUrl)
        dest?.writeString(propertyType)
        dest?.writeInt(propertyTypeId)
        dest?.writeString(publicAddress)
        dest?.writeInt(reviewsCount)
        dest?.writeString(roomType)
        dest?.writeString(roomTypeCategory)
        dest?.writeString(scrimColor)
        dest?.writeFloat(starRating)
        dest?.writeString(thumbnailUrl)
        dest?.writeInt(userId)
        dest?.writeString(xlPictureUrl)
        dest?.writeString(previewEncodedPng)
        dest?.writeStringList(pictureUrls)
        dest?.writeStringList(xlPictureUrls)
        dest?.writeInt(id)
        dest?.writeString(name)
        dest?.writeInt(bathrooms)
        dest?.writeInt(bedrooms)
        dest?.writeInt(beds)
        dest?.writeString(city)
        dest?.writeDouble(distance)
        dest?.writeDouble(lat)
        dest?.writeDouble(lng)
        dest?.writeString(neighborhood)
        dest?.writeParcelable(user, 0)
    }
}
