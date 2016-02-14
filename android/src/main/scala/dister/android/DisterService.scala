package dister.android

import android.content.Intent
import android.os.IBinder

/**
  * Created by martonpapp on 14/02/16.
  */
class DisterService extends android.app.Service {

  override def onBind(intent: Intent): IBinder = null

  override def onStartCommand(intent: Intent, flags: Int, startId: Int): Int = super.onStartCommand(intent, flags, startId)
}
