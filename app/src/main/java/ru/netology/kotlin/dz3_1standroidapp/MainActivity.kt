package ru.netology.kotlin.dz3_1standroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.kotlin.dz3_1standroidapp.dto.Post

class MainActivity : AppCompatActivity() {

    val activeColor: Int = 0xFFFF0000.toInt() // Красный цвет для текста

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(
            1, "Vasya", "First post in our network!", "20 august 2019",
            true, false, false,
            50, 0, 2
        )
        createdTv.text = post.created
        contentTv.text = post.content
        likeQtyTv.text = if (post.likesQty > 0) {
            post.likesQty.toString()
        } else " "
        commentQtyTv.text = if (post.commentsQty > 0) {
            post.commentsQty.toString()
        } else " "
        shareQtyTv.text = if (post.sharesQty > 0) {
            post.sharesQty.toString()
        } else " "

        if (post.likedByMe) {
            likeBtn.setImageResource(R.drawable.ic_favorite_active_24dp)
            likeQtyTv.setTextColor(activeColor)
        }
        if (post.commentedByMe) {
            commentBtn.setImageResource(R.drawable.ic_chat_bubble_active_24dp)
            commentQtyTv.setTextColor(activeColor)
        }
        if (post.sharedByMe) {
            shareBtn.setImageResource(R.drawable.ic_share_active_24dp)
            shareQtyTv.setTextColor(activeColor)
        }
    }
}
