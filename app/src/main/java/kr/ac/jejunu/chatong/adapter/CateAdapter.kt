package kr.ac.jejunu.chatong.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.ac.jejunu.chatong.BR
import kr.ac.jejunu.chatong.R
import kr.ac.jejunu.chatong.data.MainCateData
import kr.ac.jejunu.chatong.databinding.CategoryMainItemBinding


class CateAdapter(val items: List<MainCateData>) :
    RecyclerView.Adapter<CateAdapter.CateViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CateViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding: CategoryMainItemBinding =
            DataBindingUtil.inflate(view, R.layout.category_main_item, parent, false)

        return CateViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CateViewHolder, position: Int) {
        if(itemClick != null) {
            holder.itemView.setOnClickListener { v ->
                itemClick?.onClick(v,position)
            }
        }
        holder.bind(items[position])
    }

    class CateViewHolder(val binding: CategoryMainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Any) {
            binding.setVariable(BR.data, items)
            binding.executePendingBindings()
        }
    }
}