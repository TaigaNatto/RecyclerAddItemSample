package natto.com.recycleradditemsample


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    val viewModel: ListViewModel by lazy { ViewModelProviders.of(this).get(ListViewModel::class.java) }

    lateinit var recyclerView: RecyclerView

    val adapter: ItemAdapter by lazy {
        ItemAdapter(object : ItemActionListener {
            override fun onClickDark() {
                addItem()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById(R.id.list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter

        addItem()

        return view
    }

    fun addItem() {
        adapter.addItem()
        adapter.notifyDataSetChanged()
    }


}
