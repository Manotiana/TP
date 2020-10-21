package com.tp.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tp.newsletter.R
import com.tp.newsletter.adapters.CategoryAdapter
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
            Category("politique","https://picsum.photos/500/300"),
            Category("economie","https://picsum.photos/500/300"),
            Category("pandemie","https://picsum.photos/500/300"),
            Category("sante","https://picsum.photos/500/300"),
            Category("sante","https://picsum.photos/500/300"),
            Category("sante","https://picsum.photos/500/300"),
            Category("sante","https://picsum.photos/500/300"),
            Category("sante","https://picsum.photos/500/300"),
            Category("sante","https://picsum.photos/500/300"),
            Category("sante","https://picsum.photos/500/300")

        )

        val adapterRecycler = CategoryAdapter(articles)

        //recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)

        recyclerView.adapter = adapterRecycler
    }

}