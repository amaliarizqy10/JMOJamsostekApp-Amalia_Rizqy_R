package id.indocyber.jmojamsostekapp.activity.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.indocyber.jmojamsostekapp.activity.contact.ContactActivity
import id.indocyber.jmojamsostekapp.activity.news.NewsActivity
import id.indocyber.jmojamsostekapp.activity.profile.ProfileActivity
import id.indocyber.jmojamsostekapp.activity.program.ProgramActivity
import id.indocyber.jmojamsostekapp.databinding.LayoutHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: LayoutHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.news.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }

        binding.contact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        binding.profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        binding.cvOther.setOnClickListener {
            startActivity(Intent(this, ProgramActivity::class.java))
        }
    }
}