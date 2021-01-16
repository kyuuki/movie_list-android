package jp.kyuuki.movie_list.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.kyuuki.movie_list.MovieData
import jp.kyuuki.movie_list.R

class MainViewModel : ViewModel() {
    val movies: MutableLiveData<List<MovieData>> by lazy {
        MutableLiveData<List<MovieData>>(ArrayList())
    }

    // TODO: 初期化処理 (コンストラクタ) でこれをやりたい
    fun loadMoiveData() {
        var list = arrayListOf<MovieData>()

        var movie: MovieData

        for (i in 0..10) {
            movie = MovieData(
                R.drawable.anime,
                "One Piece($i)",
                "2030年",
                R.drawable.netfliximage,
                "http://www.netflix.com/watch/70153404"
            )
            list.add(movie)
        }

        movies.postValue(list)
    }
}
