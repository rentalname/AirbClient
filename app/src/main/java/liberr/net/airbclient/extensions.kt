package liberr.net.airbclient

import android.content.Context
import android.widget.Toast

/**
 * Created by hash on 2016/11/15.
 */

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}