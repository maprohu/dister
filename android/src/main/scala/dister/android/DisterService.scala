package dister.android

import akka.actor.ActorSystem
import android.content.Intent
import android.os.IBinder
import android.util.Log

import scala.concurrent.duration._

/**
  * Created by martonpapp on 14/02/16.
  */
class DisterService extends android.app.Service {

  override def onBind(intent: Intent): IBinder = null

  val system = ActorSystem()

  override def onStartCommand(intent: Intent, flags: Int, startId: Int): Int = {
    import system.dispatcher
    system.scheduler.schedule(3 seconds, 3 seconds) {
      Log.i("dister", "hello dister")
    }
    super.onStartCommand(intent, flags, startId)
  }

  override def onDestroy(): Unit = {
    system.shutdown()
  }

}
