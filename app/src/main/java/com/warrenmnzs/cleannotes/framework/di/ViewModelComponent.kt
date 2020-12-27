package com.warrenmnzs.cleannotes.framework.di

import com.warrenmnzs.cleannotes.framework.ListViewModel
import com.warrenmnzs.cleannotes.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {

    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}