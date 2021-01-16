package jp.kyuuki.movie_list.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.kyuuki.movie_list.R
import jp.kyuuki.movie_list.model.Video


/**
 * this is movie adapter class
 */
class MovieAdapter(
    val listener: OnItemClickListener,
    private val movieList: List<Video>
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
        val itemAdapter: Video = movieList[position]
        (holder as ViewHolder).movieTitle.text = itemAdapter.title
        (holder as ViewHolder).movieYear.text = "${itemAdapter.year}年"
        (holder as ViewHolder).movieImage.setImageResource(itemAdapter.mainImage)
        (holder as ViewHolder).netflixImage.setImageResource(itemAdapter.netflixImage)
    }

    /**
     * Setting title, Image, year and netflix image for every view
     */
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val movieTitle: TextView
        val movieYear: TextView
        val movieImage: ImageView
        val netflixImage: ImageView

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