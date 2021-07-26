package za.co.masekofortune.globotour.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import za.co.masekofortune.globotour.R
import za.co.masekofortune.globotour.city.City
import za.co.masekofortune.globotour.city.VacationSpots


class FavoriteFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var textView: TextView
    private lateinit var favoriteCityList: ArrayList<City>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        favoriteCityList = VacationSpots.favoriteCityList as ArrayList<City>

        recyclerView = view.findViewById(R.id.favorite_recycler_view)
        textView = view.findViewById(R.id.tvNoFavorites)

        if (favoriteCityList.isEmpty()) {
            showEmptyDataAlert()
        } else {
            setupRecyclerView()
        }

        return view
    }

    private fun showEmptyDataAlert() {
        textView.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        val context = requireContext()

        val favoriteCityList = VacationSpots.favoriteCityList as ArrayList<City>
        val favoriteAdapter = FavoriteAdapter(context, favoriteCityList)

        recyclerView.adapter = favoriteAdapter
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager
    }
}
