package com.warrenmnzs.cleannotes.framework

import android.content.Context
import com.warrenmnzs.cleannotes.framework.db.DatabaseService
import com.warrenmnzs.cleannotes.framework.db.NoteEntity
import com.warrenmnzs.core.data.Note
import com.warrenmnzs.core.repository.NoteDataSource

class RoomNoteDataSource(context: Context) : NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Note? = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll(): List<Note> = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}