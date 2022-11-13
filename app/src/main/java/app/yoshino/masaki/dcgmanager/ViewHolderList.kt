package app.yoshino.masaki.dcgmanager

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderList(item: View): RecyclerView.ViewHolder(item) {
    val deckList: TextView = item.findViewById(R.id.text_deck)
    val firstList: TextView = item.findViewById(R.id.text_first)
    val winList: TextView = item.findViewById(R.id.text_win)
}