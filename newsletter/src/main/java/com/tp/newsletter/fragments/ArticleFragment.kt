package com.tp.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tp.newsletter.R
import com.tp.newsletter.adapters.ArticleAdapter
import com.tp.newsletter.adapters.CategoryAdapter
import com.tp.newsletter.model.Article
import com.tp.newsletter.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

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
            bindData(result, view)
        }
    }
    private suspend fun bindData(result : List<Article>?, view: View){
        withContext(Dispatchers.Main){
            //display data in the recycler
         /* val textView = view?.findViewById<TextView>(R.id.text1)
            textView?.text = result?.get(0)?.description*/
            val recyclerView: RecyclerView = view.findViewById(R.id.article_recycler_view)
            val listOArticles = result ?: emptyList()
            val adapterRecycler = ArticleAdapter(listOArticles)
            recyclerView.layoutManager = GridLayoutManager(view.context, 1)
            recyclerView.adapter = adapterRecycler

        }
    }
}