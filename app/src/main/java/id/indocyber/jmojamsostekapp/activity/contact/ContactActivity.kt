package id.indocyber.jmojamsostekapp.activity.contact

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.indocyber.jmojamsostekapp.activity.home.HomeActivity
import id.indocyber.jmojamsostekapp.activity.news.NewsActivity
import id.indocyber.jmojamsostekapp.activity.profile.ProfileActivity
import id.indocyber.jmojamsostekapp.databinding.LayoutContactBinding
import id.indocyber.jmojamsostekapp.databinding.LayoutProfileBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: LayoutContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.news.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }

        binding.home.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}