import classes.Note
import org.junit.Assert
import org.junit.Test

internal class NoteServiceTest {

    @Test
    fun add() {
        val newNote = Note()

        val result = NoteService.add(newNote)

        Assert.assertNotEquals(0, result.id)
    }

    @Test
    fun edit_successful() {
        val newNote = NoteService.add(Note())

        val result = NoteService.edit(newNote.copy(text = "text update"))

        Assert.assertTrue(result)
    }

    @Test
    fun edit_unsuccessful() {
        val newNote = Note()

        val result = NoteService.edit(newNote)

        Assert.assertFalse(result)
    }

    @Test
    fun delete_successful() {
        val newNote = NoteService.add(Note())

        val result = NoteService.delete(newNote.id)

        Assert.assertTrue(result)
    }

    @Test
    fun delete_unsuccessful() {
        NoteService.add(Note())

        val result = NoteService.delete(Note().id)

        Assert.assertFalse(result)
    }

    @Test
    fun get() {
        NoteService.clear()
        NoteService.add(Note())
        var arrNote = emptyArray<Note>()
        arrNote += Note(id = 1)

        val result = NoteService.get()

        Assert.assertArrayEquals(result, arrNote)
    }

    @Test
    fun getById_successful() {
        val newNote = NoteService.add(Note())

        val result = NoteService.getById(newNote.id)

        Assert.assertEquals(newNote, result)
    }

    @Test
    fun getById_unsuccessful() {
        val newNote = Note()

        val result = NoteService.getById(newNote.id)

        Assert.assertNull(result)
    }
}