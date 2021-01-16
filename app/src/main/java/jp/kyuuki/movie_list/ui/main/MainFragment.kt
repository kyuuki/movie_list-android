package jp.kyuuki.movie_list.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.kyuuki.movie_list.model.Video
import jp.kyuuki.movie_list.R

class MainFragment : Fragment(), MovieAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: onCreateView, onActivityCreated どちらで呼ぶのが正しい？
        viewModel.movies.observe(viewLifecycleOwner, Observer { it ->  adapter(it, this)})
        viewModel.loadMoiveData()
    }

    private fun adapter(
        mList: List<Video>,
        listener: MainFragment
    ) {
        val mMessageAdapter = MovieAdapter(listener, mList)
        val viewManager = LinearLayoutManager(activity)
        val recyclerView = activity?.findViewById<RecyclerView>(R.id.reyclerview_list)
        val dividerItemDecoration =
            DividerItemDecoration(activity, LinearLayoutManager(activity).getOrientation())
        recyclerView?.addItemDecoration(dividerItemDecoration)
        recyclerView?.apply {
            layoutManager = viewManager
            adapter = mMessageAdapter
        }
    }

    override fun onItemClick(position: Int) {
        val clickedItem = viewModel.movies.value!![position]  // TODO: !! 排除。イベントは ViewMode で処理すべき？
        val netflix = Intent()
        netflix.action = Intent.ACTION_VIEW
        netflix.data = Uri.parse(clickedItem.netflixURL)
        netflix.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        // TODO: Activity がない場合がある？
        requireActivity().startActivity(netflix)
    }
}
