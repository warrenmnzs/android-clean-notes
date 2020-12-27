package com.warrenmnzs.core.usecase

import com.warrenmnzs.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)

}