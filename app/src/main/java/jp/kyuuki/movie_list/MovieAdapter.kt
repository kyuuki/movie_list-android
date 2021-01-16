package jp.kyuuki.movie_list

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import jp.kyuuki.movie_list.ui.main.MainFragment


/**
 * this is movie adapter class
 */
class MovieAdapter(
    val listener: OnItemClickListener,
    private val movieList: List<MovieData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemAdapter: MovieData = movieList[position]
        (holder as ViewHolder).movieTitle.text = itemAdapter.title
        (holder as ViewHolder).movieYear.text = itemAdapter.year
        (holder as ViewHolder).movieImage.setImageResource(itemAdapter.mainImage)
        (holder as ViewHolder).netflixImage.setImageResource(itemAdapter.netflixImage)
    }

    /**
     * Setting title, Image, year and netflix image for every view
     */
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var movieTitle: TextView
        var movieImage: ImageView
        var movieYear: TextView
        var netflixImage: ImageView

        init {
            movieTitle = itemView.findViewById<View>(R.id.txtMovieTitle) as TextView
            movieYear = itemView.findViewById<View>(R.id.txtMovieYear) as TextView
            movieImage = itemView.findViewById<View>(R.id.imgMovieId) as ImageView
            netflixImage = itemView.findViewById<View>(R.id.imgNetflixIcon) as ImageView

            // Setting item click listener
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}