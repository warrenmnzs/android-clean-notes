package com.warrenmnzs.cleannotes.framework.di

import android.app.Application
import com.warrenmnzs.cleannotes.framework.RoomNoteDataSource
import com.warrenmnzs.core.repository.NoteRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}