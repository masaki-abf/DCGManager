package app.yoshino.masaki.dcgmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.yoshino.masaki.dcgmanager.databinding.FirstFragmentBinding
import app.yoshino.masaki.dcgmanager.databinding.SecondFragmentBinding


class SecondFragment : Fragment(){

    companion object {
        fun newInstance(tabName: String): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle()
            args.putString("name_tab", tabName)
            fragment.setArguments(args)
            return fragment
        }
    }


    private lateinit var binding: FirstFragmentBinding
    private lateinit var recyclerView: RecyclerView

    lateinit var db: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
    var deckList = listOf("")

    var firstList = listOf(true)

    var winList = listOf(true)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = activity?.let { AppDatabase.getInstance(it.applicationContext) }!!

        val args = arguments
        val index = args?.getString("name_tab")

        val matchList = index?.let { db.matchesDao().getGmae(it) }

        if (matchList != null) {
            deckList = matchList.map { it.deck }.toList()
        }
        if (matchList != null) {
            firstList = matchList.map { it.first}.toList()
        }
        if (matchList != null) {
            winList = matchList.map { it.win }.toList()
        }

        val firstListUpdated = firstList.map{if (it) "First" else "Second"}
        val winListUpdated = winList.map{if (it) "Win" else "Lose"}

        recyclerView = binding.recyclerView
        recyclerView.adapter = RecyclerAdapter(deckList,firstListUpdated,winListUpdated)
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
}