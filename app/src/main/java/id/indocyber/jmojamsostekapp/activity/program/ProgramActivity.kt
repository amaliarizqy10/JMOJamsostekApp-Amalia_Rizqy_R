package id.indocyber.jmojamsostekapp.activity.program

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import id.indocyber.jmojamsostekapp.activity.contact.ContactActivity
import id.indocyber.jmojamsostekapp.activity.home.HomeActivity
import id.indocyber.jmojamsostekapp.activity.news.NewsActivity
import id.indocyber.jmojamsostekapp.activity.news.ProgramAdapter
import id.indocyber.jmojamsostekapp.activity.profile.ProfileActivity
import id.indocyber.jmojamsostekapp.databinding.LayoutProgramBinding
import id.indocyber.jmojamsostekapp.viewmodel.ProgramViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProgramActivity : AppCompatActivity() {

    lateinit var binding:LayoutProgramBinding
    val adapter = ProgramAdapter(::getSelectedProgram)

    private val vm: ProgramViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutProgramBinding.inflate(LayoutInflater.from(this), null, false)
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.rvProgram.adapter = adapter
        vm.programData.observe(this){
            adapter.submitData(it)
        }

        binding.home.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.contact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        binding.profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        binding.news.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }
    }

    fun getSelectedProgram() : ArrayList<String> = vm.selectedProgram

}