package app.yoshino.masaki.dcgmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.yoshino.masaki.dcgmanager.databinding.ItemRecyclerListBinding

class RecyclerAdapter (val deck: List<String>,val first: List<String>,val win:List<String>):
    RecyclerView.Adapter<ViewHolderList>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_list,parent,false)
        return ViewHolderList(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int){
        holder.deckList.text = deck[position]
        holder.firstList.text = first[position]
        holder.winList.text = win[position]
    }
    override fun getItemCount(): Int = deck.size

    private val diffUtilItemCallback = object : DiffUtil.ItemCallback<Matches> (){
        override fun areContentsTheSame(oldItem: Matches, newItem: Matches): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Matches, newItem: Matches): Boolean {
            return oldItem.id == newItem.id
        }
    }
//    class OnClickListener(val clickListener: (matches: Matches) -> Unit)
//    fun onClick(matches: Matches) = clickListener(matches)
}