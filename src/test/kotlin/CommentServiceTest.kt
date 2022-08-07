import classes.Comment
import org.junit.Assert
import org.junit.Test

internal class CommentServiceTest {

    @Test
    fun add() {
        val newComment = Comment()

        val result = CommentService.add(newComment)

        Assert.assertNotEquals(0, result.id)
    }

    @Test
    fun edit_successful() {
        val newComment = CommentService.add(Comment())

        val result = CommentService.edit(newComment.copy(message = "text update"))

        Assert.assertTrue(result)
    }

    @Test
    fun edit_unsuccessful() {
        val newComment = Comment()

        val result = CommentService.edit(newComment)

        Assert.assertFalse(result)
    }

    @Test
    fun delete_successful() {
        val newComment = CommentService.add(Comment())

        val result = CommentService.delete(newComment.id)

        Assert.assertTrue(result)
    }

    @Test
    fun delete_unsuccessful() {
        CommentService.add(Comment())

        val result = CommentService.delete(Comment().id)

        Assert.assertFalse(result)
    }

    @Test
    fun get() {
        CommentService.clear()
        CommentService.add(Comment())
        var arrComment = emptyArray<Comment>()
        arrComment += Comment(id = 1)

        val result = CommentService.get()

        Assert.assertArrayEquals(result, arrComment)
    }

    @Test
    fun getById_successful() {
        val newComment = CommentService.add(Comment())

        val result = CommentService.getById(newComment.id)

        Assert.assertEquals(newComment, result)
    }

    @Test
    fun getById_unsuccessful() {
        val newComment = Comment()

        val result = CommentService.getById(newComment.id)

        Assert.assertNull(result)
    }

    @Test
    fun restore_successful() {
        val newComment = CommentService.add(Comment())
        CommentService.delete(newComment.id)

        val result = CommentService.restore(newComment.id)

        Assert.assertTrue(result)
    }

    @Test
    fun restore_unsuccessful() {
        val newComment = CommentService.add(Comment())
        CommentService.delete(newComment.id)

        val result = CommentService.restore(-1)

        Assert.assertFalse(result)
    }
}