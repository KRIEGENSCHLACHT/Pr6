package ru.btpit.nmedia.viewmodel

import androidx.lifecycle.ViewModel
import ru.btpit.nmedia.repository.PostRepository
import ru.btpit.nmedia.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
    fun likeById(id: Int)=repository.likedById(id)
    fun shareById(id: Int)=repository.sharedById(id)
}