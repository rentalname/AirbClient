package liberr.net.airbclient

import com.squareup.moshi.Moshi
import liberr.net.airbclient.model.SearchResponse
import liberr.net.airbclient.model.SearchResult
import org.junit.Test


/**
 * Created by hash on 2016/11/16.
 */
data class BlackjackHand(
        val hidden_card: Card,
        val visible_cards: List<Card>)

data class Card(
        val rank: Char,
        val suit: Suit)

enum class Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES
}

class MoshiTest {

    @Test
    fun `JSONパース`() {
        val json = """
            {
              "hidden_card": {
                "rank": "6",
                "suit": "SPADES"
              },
              "visible_cards": [
                {
                  "rank": "4",
                  "suit": "CLUBS"
                },
                {
                  "rank": "A",
                  "suit": "HEARTS"
                }
              ]
            }
        """

        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(BlackjackHand::class.java)

        val blackjackHand = jsonAdapter.fromJson(json)
        println(blackjackHand)
    }

    @Test
    fun `AirBnb_API_レスポンス_パース`() {
        val json = """
            {
              "search_results": [
                {
                  "listing": {
                    "airbnb_plus_enabled": false,
                    "bathrooms": 1,
                    "bedrooms": 1,
                    "beds": 1,
                    "city": "Parranquet",
                    "coworker_hosted": false,
                    "distance": null,
                    "extra_host_languages": [],
                    "id": 9747957,
                    "instant_bookable": false,
                    "is_business_travel_ready": false,
                    "is_new_listing": false,
                    "lat": 44.66332452611567,
                    "listing_tags": [],
                    "lng": 0.8104567244810624,
                    "name": "Romantic tower in deep countryside",
                    "neighborhood": null,
                    "person_capacity": 2,
                    "picture_count": 11,
                    "picture_url": "https://a2.muscache.com/im/pictures/fb555602-f944-4b41-ad27-93516f0fc322.jpg?aki_policy=large",
                    "property_type": "House",
                    "property_type_id": 2,
                    "public_address": "Parranquet, Aquitaine, France",
                    "reviews_count": 6,
                    "room_type": "Entire home/apt",
                    "room_type_category": "entire_home",
                    "scrim_color": "",
                    "star_rating": 4.5,
                    "thumbnail_url": "https://a2.muscache.com/im/pictures/fb555602-f944-4b41-ad27-93516f0fc322.jpg?aki_policy=small",
                    "user": {
                      "first_name": "Jolyon",
                      "has_profile_pic": true,
                      "id": 5933859,
                      "picture_url": "https://a0.muscache.com/im/users/5933859/profile_pic/1429702930/original.jpg?aki_policy=profile_x_medium",
                      "smart_name": "Jolyon",
                      "thumbnail_url": "https://a0.muscache.com/im/users/5933859/profile_pic/1429702930/original.jpg?aki_policy=profile_small",
                      "is_superhost": false
                    },
                    "user_id": 5933859,
                    "xl_picture_url": "https://a2.muscache.com/im/pictures/fb555602-f944-4b41-ad27-93516f0fc322.jpg?aki_policy=x_large",
                    "preview_encoded_png": "",
                    "picture_urls": [
                      "https://a2.muscache.com/im/pictures/e3d553fc-e182-4586-9f3d-3b001f0630a2.jpg?aki_policy=large",
                      "https://a2.muscache.com/im/pictures/063b8d17-39d1-4adc-b4d6-80852c02dd56.jpg?aki_policy=large"
                    ],
                    "xl_picture_urls": [
                      "https://a2.muscache.com/im/pictures/e3d553fc-e182-4586-9f3d-3b001f0630a2.jpg?aki_policy=x_large",
                      "https://a2.muscache.com/im/pictures/063b8d17-39d1-4adc-b4d6-80852c02dd56.jpg?aki_policy=x_large"
                    ]
                  },
                  "pricing_quote": {
                    "guests": 1,
                    "guest_details": {
                      "number_of_adults": 1
                    },
                    "listing_currency": "GBP",
                    "localized_currency": "USD",
                    "localized_nightly_price": 44,
                    "nightly_price": 43
                  }
                }
              ]
            }
        """

        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(SearchResponse::class.java)

        val searchResult = jsonAdapter.fromJson(json)
        println(searchResult)
    }
}