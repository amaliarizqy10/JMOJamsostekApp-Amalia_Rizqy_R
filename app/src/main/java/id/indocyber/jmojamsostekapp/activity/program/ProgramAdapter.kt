package id.indocyber.jmojamsostekapp.activity.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.indocyber.common.entity.berita.NewsResponseItem
import id.indocyber.jmojamsostekapp.databinding.LayoutNewsItemBinding
import id.indocyber.jmojamsostekapp.databinding.LayoutProgramItemBinding

class ProgramAdapter(val getSelectedProgram: () -> ArrayList<String>) : RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder>(){

    val listDiffer = AsyncListDiffer(this, differ)


inner class ProgramViewHolder(val binding:LayoutProgramItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(program: String, getSelectedProgram : () -> ArrayList<String>){
        binding.tvProgram.text = program

        binding.root.setOnClickListener {
            val selectedProgram = getSelectedProgram()
            if (program in selectedProgram) {
                selectedProgram.remove(program)
            } else {
                selectedProgram.add(program)
            }
            notifyItemChanged(adapterPosition)
        }

        binding.selected.visibility = if (getSelectedProgram() == null) View.VISIBLE else View.INVISIBLE
    }
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder =
        ProgramViewHolder(LayoutProgramItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        holder.bind(listDiffer.currentList[position], getSelectedProgram)
    }

    fun submitData(list: List<String>){
        listDiffer.submitList(list)
    }

    override fun getItemCount(): Int = listDiffer.currentList.size

    companion object{
        val differ = object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: String,
                newItem: String
            ): Boolean {
                return true
            }
        }
    }

}

