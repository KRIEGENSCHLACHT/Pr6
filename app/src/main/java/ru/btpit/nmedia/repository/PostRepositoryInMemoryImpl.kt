package ru.btpit.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.btpit.nmedia.dto.Post

class PostRepositoryInMemoryImpl : PostRepository{
    private var posts = listOf(
        Post(
            id = 1,
            author = "КД-Саунд - мастерская звукоаппаратуры",
            content = "Купили дом, завезли красивую мебель, приобрели навороченную плазму - а звука нет? Тогда вам стоит посетить КД-Саунд в Борисоглебске! Мы делаем Hi-Fi оборудование на заказ на территории Борисоглебска, возможна доставка по области",
            published = "25 марта в 13:01",
            likedByMe = false,
            likes = 999999,
            share = 999,
            sharedByMe = false
        ),
        Post(
            id = 2,
            author = "КД-Саунд - мастерская звукоаппаратуры",
            content = "Дамы и господа, колонки ЗАКОНЧИЛИСЬ. Продажи закрыты.",
            published = "01 марта в 3:01",
            likedByMe = false,
            likes = 999999,
            share = 999,
            sharedByMe = false
        ),
    )
    private val data = MutableLiveData(posts)
    override fun getAll(): LiveData<List<Post>> = data
    override fun likedById(id: Int) {
        posts = posts.map {
            if(it.id!= id.toInt()) it else it.copy(likedByMe = !it.likedByMe)
        }
        posts.map{
            if(it.likedByMe && it.id == id.toInt()) it.likes++ else it
        }
        posts.map {
            if(!it.likedByMe && it.id == id.toInt()) it.likes-- else it
        }
        data.value = posts
    }
    override fun sharedById(id: Int) {
        posts = posts.map {
            if(it.id!= id.toInt()) it else it.copy(sharedByMe = !it.sharedByMe)
        }
        posts.map {
            if (it.id != id.toInt()) it else it.share++
        }
        data.value = posts
    }
}




