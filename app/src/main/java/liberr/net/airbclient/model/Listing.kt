package liberr.net.airbclient.model

import com.squareup.moshi.Json

data class Listing(
        @Json(name = "person_capacity")
        val personCapacity: Int,
        @Json(name = "listing_tags")
        val listingTags: List<Any>,
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
        val starRating: Float?,
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
        val distance: Any,
        val lat: Double,
        val lng: Double,
        val neighborhood: String,
        val user: User
)
