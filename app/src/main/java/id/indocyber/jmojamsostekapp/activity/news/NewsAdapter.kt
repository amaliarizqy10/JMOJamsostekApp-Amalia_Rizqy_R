package id.indocyber.jmojamsostekapp.activity.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.indocyber.common.entity.berita.NewsResponseItem
import id.indocyber.jmojamsostekapp.databinding.LayoutNewsItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>(){

    val listDiffer = AsyncListDiffer(this, differ)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(LayoutNewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listDiffer.currentList[position])
    }

    fun submitData(list: List<NewsResponseItem>){
        listDiffer.submitList(list)
    }

    override fun getItemCount(): Int = listDiffer.currentList.size

    companion object{
        val differ = object : DiffUtil.ItemCallback<NewsResponseItem>(){
            override fun areItemsTheSame(
                oldItem: NewsResponseItem,
                newItem: NewsResponseItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: NewsResponseItem,
                newItem: NewsResponseItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}

class NewsViewHolder(val binding:LayoutNewsItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: NewsResponseItem){
        binding.newsTitle.text = data.title
        binding.newsBody.text = data.body
    }
}
