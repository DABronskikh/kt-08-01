package classes

data class Comment(
    val id: Int = 0,
    val noteId: Int = 0,
    val replyTo: Int = 0,
    val message: String = "",
    val deleted: Boolean = false,
)
