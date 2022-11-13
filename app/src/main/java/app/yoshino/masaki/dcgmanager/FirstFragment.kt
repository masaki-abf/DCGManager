package app.yoshino.masaki.dcgmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.yoshino.masaki.dcgmanager.databinding.FirstFragmentBinding

class FirstFragment : Fragment(){
    private lateinit var binding: FirstFragmentBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
    val deckList = listOf(
        "マリオ",
        "ルイージ",
        "ピーチ"
    )

    val firstList = listOf(
        "First",
        "EnemyFirst",
        "First"
    )

    val winList = listOf(
        "win",
        "win",
        "lose"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerView
        recyclerView.adapter = RecyclerAdapter(deckList,firstList,winList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
}