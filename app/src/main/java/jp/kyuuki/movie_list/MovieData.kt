package jp.kyuuki.movie_list

/**
 * This is data class for movie
 */
data class MovieData(
    var mainImage: Int,
    var title: String,
    var year: String,
    var netflixImage: Int,
    var netflixURL: String
)