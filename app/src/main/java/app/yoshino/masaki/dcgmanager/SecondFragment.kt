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

class SecondFragment : Fragment(){private lateinit var binding: FirstFragmentBinding
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

    var firstList = listOf("")

    var winList = listOf("")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = activity?.let { AppDatabase.getInstance(it.applicationContext) }!!

        val matchList = db.matchesDao().getAll()

        deckList = matchList.map { it.deck }.toList()
        firstList = matchList.map { it.first.toString() }.toList()
        winList = matchList.map { it.win.toString() }.toList()

        recyclerView = binding.recyclerView
        recyclerView.adapter = RecyclerAdapter(deckList,firstList,winList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
}