package xyz.surelabs.dicodingsubmissionrecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import xyz.surelabs.dicodingsubmissionrecyclerview.R
import xyz.surelabs.dicodingsubmissionrecyclerview.models.NewsModel

class NewsAdapter(
    private val context: Context?, private val list: List<NewsModel>,
    private val onclick: OnItemListClickListener
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            context,
            onclick,
            LayoutInflater.from(context).inflate(R.layout.fragment_news_adapter, p0, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.onBindItem(list.get(p1))
    }

    class ViewHolder(
        val context: Context?,
        val onclick: OnItemListClickListener,
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val title = itemView.findViewById<TextView>(R.id.title)
        val from = itemView.findViewById<TextView>(R.id.from)
        val pubDate = itemView.findViewById<TextView>(R.id.pubDate)


        fun onBindItem(model: NewsModel) {
            Log.d("IMAGE", model.image)
            context?.let { Glide.with(it).load(model.image).into(image) }
            title.text = model.title
            from.text = model.from
            pubDate.text = model.pubDate

            itemView.setOnClickListener {
                onclick.onItemClick(model)
            }
        }
    }

    interface OnItemListClickListener {
        fun onItemClick(model: NewsModel)
    }

}
