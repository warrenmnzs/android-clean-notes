package com.warrenmnzs.cleannotes.framework.di

import com.warrenmnzs.cleannotes.framework.UseCases
import com.warrenmnzs.core.repository.NoteRepository
import com.warrenmnzs.core.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun getUserCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}