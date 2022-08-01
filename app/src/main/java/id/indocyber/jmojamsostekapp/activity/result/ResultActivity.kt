package id.indocyber.jmojamsostekapp.activity.result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.indocyber.jmojamsostekapp.activity.contact.ContactActivity
import id.indocyber.jmojamsostekapp.activity.home.HomeActivity
import id.indocyber.jmojamsostekapp.activity.news.NewsActivity
import id.indocyber.jmojamsostekapp.activity.profile.ProfileActivity
import id.indocyber.jmojamsostekapp.databinding.LayoutLoginBinding
import id.indocyber.jmojamsostekapp.databinding.LayoutResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: LayoutResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}