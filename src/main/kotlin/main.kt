import classes.Comment
import classes.Note
import interfaces.CrudService

fun main() {
}

object NoteService : CrudService<Note>() {

    override fun add(elem: Note): Note {
        val newElem = elem.copy(id = getUid())
        elements.add(newElem)
        return elements.last()
    }

    override fun edit(elem: Note): Boolean {
        for ((index, itemElem) in elements.withIndex()) {
            if (itemElem.id == elem.id) {
                elements[index] = elements[index].copy(
                    title = elem.title,
                    text = elem.text,
                    privacy = elem.privacy,
                    commentPrivacy = elem.commentPrivacy,
                    privacyView = elem.privacyView,
                    privacyComment = elem.privacyComment,
                )
                return true
            }
        }

        return false
    }

    override fun delete(id: Int): Boolean {
        var result = false
        for ((index, itemElem) in elements.withIndex()) {
            if (itemElem.id == id) {
                elements[index] = elements[index].copy(deleted = true)
                result = true
            }
        }

        return result
    }

    override fun get(): Array<Note> {
        return (elements.filter { itemElem -> !itemElem.deleted }).toTypedArray()
    }

    override fun getById(id: Int): Note? {
        return elements.find { itemElem -> itemElem.id == id && !itemElem.deleted }
    }
}

object CommentService : CrudService<Comment>() {
    override fun add(elem: Comment): Comment {
        val newElem = elem.copy(id = getUid())
        elements.add(newElem)
        return elements.last()
    }

    override fun edit(elem: Comment): Boolean {
        for ((index, itemElem) in elements.withIndex()) {
            if (itemElem.id == elem.id) {
                elements[index] = elements[index].copy(
                    noteId = elem.noteId,
                    replyTo = elem.replyTo,
                    message = elem.message,
                )
                return true
            }
        }

        return false
    }

    override fun delete(id: Int): Boolean {
        var result = false
        for ((index, itemElem) in elements.withIndex()) {
            if (itemElem.id == id) {
                elements[index] = elements[index].copy(deleted = true)
                result = true
            }
        }

        return result
    }

    override fun get(): Array<Comment> {
        return (elements.filter { itemElem -> !itemElem.deleted }).toTypedArray()
    }

    override fun getById(id: Int): Comment? {
        return elements.find { itemElem -> itemElem.id == id && !itemElem.deleted }
    }

    fun restore(id: Int): Boolean {
        var result = false
        for ((index, itemElem) in elements.withIndex()) {
            if (itemElem.id == id) {
                elements[index] = elements[index].copy(deleted = false)
                result = true
            }
        }

        return result
    }
}