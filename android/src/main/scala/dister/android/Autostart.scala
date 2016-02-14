package dister.android

import android.content.{Intent, Context, BroadcastReceiver}
import android.util.Log

/**
  * Created by martonpapp on 14/02/16.
  */
class Autostart extends BroadcastReceiver {
  override def onReceive(context: Context, intent: Intent): Unit = {
    val intent = new Intent(context, classOf[DisterService])
    context.startService(intent)
    Log.i("dister", "dister autostart started")
  }
}
