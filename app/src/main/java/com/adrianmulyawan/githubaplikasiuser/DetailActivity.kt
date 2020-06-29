package com.adrianmulyawan.githubaplikasiuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_USER_GITHUB = "detail_user_github"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Github User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val users = intent.getParcelableExtra(DETAIL_USER_GITHUB) as User

        user_photo.setImageResource(users.Avatar)
        user_name.text = users.Name.toString()
        user_lokasi.text = users.Location.toString()
        user_user_username.text = "@${users.Username.toString()}"
        user_repository.text = "Repository : ${users.Repository.toString()}"
        button1.text = """
            ${users.Follower.toString()}
            Followers
        """.trimIndent()
        button2.text = """
            ${users.Following.toString()}
            Following
        """.trimIndent()
    }
}