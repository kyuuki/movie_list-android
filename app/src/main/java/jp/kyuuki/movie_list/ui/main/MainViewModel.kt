package jp.kyuuki.movie_list.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.kyuuki.movie_list.model.Video
import jp.kyuuki.movie_list.R

class MainViewModel : ViewModel() {
    val movies: MutableLiveData<List<Video>> by lazy {
        MutableLiveData<List<Video>>(ArrayList())
    }

    fun loadMoiveData() {
        var list = arrayListOf<Video>()

        var movie: Video

        for (i in 0..10) {
            movie = Video(
                "One Piece($i)",
                2000 + i,
                R.drawable.anime,
                R.drawable.netfliximage,
                "http://www.netflix.com/watch/70153404"
            )
            list.add(movie)
        }

        movies.postValue(list)
    }
}
