package liberr.net.airbclient.model

import android.os.Parcel
import android.os.Parcelable

data class User(
        var firstName: String,
        var id: Int,
        var pictureUrl: String,
        var smartName: String,
        var thumbnailUrl: String
) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readInt(), source.readString(), source.readString(), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(firstName)
        dest?.writeInt(id)
        dest?.writeString(pictureUrl)
        dest?.writeString(smartName)
        dest?.writeString(thumbnailUrl)
    }
}
