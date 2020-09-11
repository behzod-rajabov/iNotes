package inotes.ic0der.uz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inotes.ic0der.uz.db.Note
import kotlinx.android.synthetic.main.item_layout.view.*

class AdapterNote(val onClickListener: (note: Note) -> Unit) :
    RecyclerView.Adapter<AdapterNote.ViewHolder>() {

    val list = mutableListOf<Note>()

    fun setList(newList: List<Note>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) {
            itemView.title.text = note.title
            itemView.description.text = note.description
            itemView.setOnClickListener{
                onClickListener(note)
            }
        }
    }


}