package app.yoshino.masaki.dcgmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

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
}