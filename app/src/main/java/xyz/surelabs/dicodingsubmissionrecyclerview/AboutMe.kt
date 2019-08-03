package xyz.surelabs.dicodingsubmissionrecyclerview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about_me.*

class AboutMe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About Me"


        Glide.with(this)
            .load("https://www.dicoding.com/images/small/avatar/2019080322043193c9a2dca01c793b0036a0e534b47c93.jpg")
            .centerCrop().circleCrop()
            .into(fotoProfile)
        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:sigitharsy25@gmail.com")
            startActivity(Intent.createChooser(intent, "Continue with..."))
        }

        detail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.dicoding.com/users/738")
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
