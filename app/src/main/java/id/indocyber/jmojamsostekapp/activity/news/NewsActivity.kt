package id.indocyber.jmojamsostekapp.activity.news

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.indocyber.common.entity.base_response.ResponseError
import id.indocyber.common.entity.base_response.ResponseLoading
import id.indocyber.common.entity.base_response.ResponseSuccess
import id.indocyber.jmojamsostekapp.activity.contact.ContactActivity
import id.indocyber.jmojamsostekapp.activity.home.HomeActivity
import id.indocyber.jmojamsostekapp.activity.profile.ProfileActivity
import id.indocyber.jmojamsostekapp.databinding.LayoutNewsBinding
import id.indocyber.jmojamsostekapp.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {
    private val vm: NewsViewModel by viewModel()
    private val adapter = NewsAdapter()
    private lateinit var binding: LayoutNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.rvNews.adapter = adapter
        vm.newsData.observe(this){
             adapter.submitData(it.data.orEmpty())
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
    }
}