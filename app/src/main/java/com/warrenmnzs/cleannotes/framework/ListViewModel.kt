package com.warrenmnzs.cleannotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.warrenmnzs.cleannotes.framework.di.ApplicationModule
import com.warrenmnzs.cleannotes.framework.di.DaggerViewModelComponent
import com.warrenmnzs.core.data.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build().inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList: List<Note> = useCases.getAllNotes()
            noteList.forEach { it.wordCount = useCases.getWordCount.invoke(it) }
            notes.postValue(noteList)
        }
    }
}