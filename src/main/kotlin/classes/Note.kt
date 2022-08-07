package classes

data class Note(
    val id: Int = 0,
    val title: String = "",
    val text: String = "",
    val privacy: Int = 0,
    val commentPrivacy: Int = 0,
    val privacyView: String = "",
    val privacyComment: String = "",
    val deleted: Boolean = false,
)
