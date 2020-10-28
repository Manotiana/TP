package com.tp.newsletter.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tp.newsletter.R
import com.tp.newsletter.adapters.ArticleAdapter
import com.tp.newsletter.model.Article
import com.tp.newsletter.repository.ArticleRepository
import com.tp.newsletter.utils.EndlessRecyclerViewScrollListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleFragment : Fragment() {
    lateinit var category : String
    lateinit var repository : ArticleRepository
     var totalCount : Int?= 0
    var pageCounter = 2
    var loading = true
    var pageLimit = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch{
            getData(view);
        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArticleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(category :String) =
            ArticleFragment().apply {
                this.category = category
                this.repository = ArticleRepository(category)
            }



    }

    private suspend fun getData(view: View){
        withContext(Dispatchers.IO){
            //val result = repository.list()
            val result = repository.getArticles()
            totalCount = result.first
            pageLimit = totalCount?.div(20) ?: 100
            Log.d("page limit to display", pageLimit.toString())
            bindData(result.second, view)
        }
    }
    private suspend fun bindData(result : List<Article>?, view: View){
        withContext(Dispatchers.Main){
            //display data in the recycler
         /* val textView = view?.findViewById<TextView>(R.id.text1)
            textView?.text = result?.get(0)?.description*/
            val recyclerView: RecyclerView = view.findViewById(R.id.article_recycler_view)
            val listOArticles = result ?: emptyList()
            val adapterRecycler = ArticleAdapter(listOArticles.toMutableList())
            val gridLayoutManager = GridLayoutManager(view.context, 1)
            recyclerView.layoutManager = gridLayoutManager
            recyclerView.adapter = adapterRecycler
            val scrollListener = object : EndlessRecyclerViewScrollListener(gridLayoutManager, pageLimit) {

                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                    // Triggered only when new data needs to be appended to the list
                    // Add whatever code is needed to append new items to the bottom of the list
                    lifecycleScope.launch(Dispatchers.IO) {

                        //if(pageCounter < pageLimit){
                            loadNextDataFromApi(page, view)
                            Log.d("onloadmore","onloadmore called")
                            //withContext(Dispatchers.Main){}
                            //pageCounter ++
                        //}



                    }

                }
            }
            recyclerView.addOnScrollListener(scrollListener)

            /*recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) { //check for scroll down
                        val visibleItemCount = gridLayoutManager.childCount
                        val pastVisiblesItems = gridLayoutManager.findFirstCompletelyVisibleItemPosition()
                        val totalItemCount = recyclerView.adapter?.itemCount ?: 20

                        if (loading) {
                            if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                                loading = false
                                Log.v("...", "Last Item Wow !")
                                launch (Dispatchers.IO){
                                    loadNextDataFromApi(2, recyclerView)
                                    loading = true
                                }

                            }
                        }
                    }
                }
            })*/
        }
    }
    private suspend fun loadNextDataFromApi( page: Int, view: RecyclerView){
        withContext(Dispatchers.IO){
            val nextResult = repository.getNextArticles(page) ?: emptyList()

            withContext(Dispatchers.Main){
                Log.d("LoadNextFromApi","${page.toString()} + ${nextResult.size}")
                val recyclerView: RecyclerView = view.findViewById(R.id.article_recycler_view)
                val adapter : ArticleAdapter = recyclerView.adapter as ArticleAdapter
                adapter.addNextResults(nextResult)
            }


        }
    }
}