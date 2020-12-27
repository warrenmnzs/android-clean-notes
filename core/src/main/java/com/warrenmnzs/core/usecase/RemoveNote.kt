package com.warrenmnzs.core.usecase

import com.warrenmnzs.core.data.Note
import com.warrenmnzs.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)
}