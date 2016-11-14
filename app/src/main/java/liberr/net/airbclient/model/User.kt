package liberr.net.airbclient.model

data class User(
        var firstName: String,
        var hasProfilePic: Boolean,
        var id: Int,
        var pictureUrl: String,
        var smartName: String,
        var thumbnailUrl: String,
        var isSuperhost: Boolean
)
