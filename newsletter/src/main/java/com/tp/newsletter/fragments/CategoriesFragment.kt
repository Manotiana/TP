package com.tp.newsletter.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.children
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tp.newsletter.MainActivity
import com.tp.newsletter.R
import com.tp.newsletter.adapters.CategoryAdapter
import com.tp.newsletter.changeFragment
import com.tp.newsletter.model.Category

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        val articles = listOf<Category>(
                Category("politics","https://i.postimg.cc/Kc0bJ4Ch/politique2.jpg "),
                Category("business","https://i.postimg.cc/3JrXQfLD/business.jpg"),
                Category("education","https://i.postimg.cc/MZ3TXs6B/education.jpg"),
                Category("pandemic","https://i.postimg.cc/mk1GPyj3/pandemie.jpg"),
                Category("sciences","https://i.postimg.cc/9Xy2HJ4V/sciences.jpg"),
                Category("ecology","https://i.postimg.cc/J7Nf20gz/ecoligie.jpg")
        )

        val adapterRecycler = CategoryAdapter(articles){
            partItemClicked(it)
        }

        //recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)

        recyclerView.adapter = adapterRecycler


    }
    private fun partItemClicked(category: Category ) {
      // context?.toast(category.name)
        Toast.makeText(
            context,
            category.name,
            Toast.LENGTH_LONG
        ).show()
        (activity as? MainActivity)?.changeFragment(
            ArticleFragment.newInstance(
                category.name
            )
        )

    }

}
fun Context.toast(display:String){
    Toast.makeText(
        this,
        display,
        Toast.LENGTH_LONG
    ).show()
}
