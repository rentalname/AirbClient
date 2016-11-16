package liberr.net.airbclient

import android.content.Context
import android.widget.Toast
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by hash on 2016/11/15.
 */

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).into(this)
}