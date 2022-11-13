package app.yoshino.masaki.dcgmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.yoshino.masaki.dcgmanager.databinding.SecondFragmentBinding

class SecondFragment : Fragment(){
    private lateinit var binding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}