package xyz.surelabs.dicodingsubmissionrecyclerview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_news_detail.*
import xyz.surelabs.dicodingsubmissionrecyclerview.models.NewsModel

class NewsDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getSerializableExtra("detail") as NewsModel
        titles.text = data.title
        supportActionBar?.title = "News by ${data.from}"
        pubOnAndBy.text = "By ${data.from}. ${data.pubDate}"
        Glide.with(this).load(data.image).into(image)
        detail.text = data.content
        selengkapnya.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(data.url)
            startActivity(Intent.createChooser(intent, "Continue with..."))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> NavUtils.navigateUpTo(this, Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
