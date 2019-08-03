@file:Suppress("DEPRECATION")

package xyz.surelabs.dicodingsubmissionrecyclerview

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import xyz.surelabs.dicodingsubmissionrecyclerview.adapter.NewsAdapter
import xyz.surelabs.dicodingsubmissionrecyclerview.models.NewsModel


class MainActivity : AppCompatActivity(), NewsAdapter.OnItemListClickListener {

    private var pd: ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Dicoding News"
        pd = ProgressDialog.show(this, "Load", "Load the news....")
        Handler().postDelayed({
            loadDataNews()
        }, 3000)
    }

    private fun loadDataNews() {
        pd?.dismiss()

        val list = mutableListOf<NewsModel>()
        val title = resources.getStringArray(R.array.title)
        val link = resources.getStringArray(R.array.link)
        val image = resources.getStringArray(R.array.image)
        val published = resources.getStringArray(R.array.published)
        val content = resources.getStringArray(R.array.content)
        title.forEachIndexed { index, s ->
            val data = NewsModel(
                title = s,
                from = getString(R.string.hacker),
                pubDate = published.get(index),
                image = image.get(index),
                url = link.get(index),
                content = content.get(index)
            )

            list.add(data)
        }

        val adapter = NewsAdapter(this, list, this)
        lisNews.adapter = adapter
        lisNews.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(model: NewsModel) {
        val intent = Intent(this, NewsDetail::class.java)
        intent.putExtra("detail", model)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.about -> startActivity(Intent(this, AboutMe::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
