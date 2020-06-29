package com.adrianmulyawan.githubaplikasiuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>

    private var usersGit = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Github User Application"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = UserAdapter(this)

        prepare()
        addItem()

        lv_user_github.divider = null
        lv_user_github.adapter = adapter
        lv_user_github.onItemClickListener =
            AdapterView.OnItemClickListener {_, _, position, _ ->
                val moveUser = User (
                    usersGit[position].Username,
                    usersGit[position].Name,
                    usersGit[position].Avatar,
                    usersGit[position].Company,
                    usersGit[position].Location,
                    usersGit[position].Repository,
                    usersGit[position].Follower,
                    usersGit[position].Following
                )

                val moveDetailActivity = Intent(this@MainActivity,
                    DetailActivity::class.java)
                moveDetailActivity.putExtra(DetailActivity.DETAIL_USER_GITHUB, moveUser)
                startActivity(moveDetailActivity)
            }
    }

    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val userGit = User(
                dataUsername[position],
                dataName[position],
                dataAvatar.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position]
            )
            usersGit.add(userGit)
        }
        adapter.users = usersGit
    }

}