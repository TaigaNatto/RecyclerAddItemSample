package natto.com.recycleradditemsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val listener: ItemActionListener) : RecyclerView.Adapter<ItemAdapter.ListViewHolder>() {
    private val items = ArrayList<ItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_num, parent, false)
        return ListViewHolder(inflate)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        if (items[position].isLast) {
            holder.darkView.visibility = View.VISIBLE
        } else {
            holder.darkView.visibility = View.GONE
            holder.textEditView.isFocusable = true
            holder.textEditView.isFocusableInTouchMode = true
            holder.textEditView.requestFocus()
        }
        holder.darkView.setOnClickListener {
            listener.onClickDark()
        }
        holder.textEditView.setText(items[position].text)
    }

    fun addItem() {
        if (items.isNotEmpty()) {
            items[items.size - 1].isLast = false
        }
        items.add(
            ItemData(
                isLast = true
            )
        )
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textEditView: EditText = itemView.findViewById(R.id.text_edit_view)
        var darkView: View = itemView.findViewById(R.id.dark_view)
    }
}