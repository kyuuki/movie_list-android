package jp.kyuuki.movie_list.model

/**
 * This is data class for movie
 */
data class Video(
    val title: String,
    val year: Int,
    val mainImage: Int,
    val netflixImage: Int,
    val netflixURL: String
)