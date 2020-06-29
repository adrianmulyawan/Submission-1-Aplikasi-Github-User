package com.adrianmulyawan.githubaplikasiuser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_row_user.view.*

class UserAdapter constructor(private val context: Context) : BaseAdapter() {

    internal var users = arrayListOf<User>()

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(i: Int): Any {
        return users[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_row_user, parent, false)

        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        fun bind(user: User) {
            with(view) {
                tv_nama_pengguna.text = user.Name
                tv_lokasi_pengguna.text = user.Location
                tv_username_pengguna.text = user.Username
                iv_avatar_user.setImageResource(user.Avatar)
            }
        }
    }

}