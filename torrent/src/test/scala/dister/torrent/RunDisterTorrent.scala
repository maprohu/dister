package dister.torrent

import java.net.InetAddress

import com.turn.ttorrent.client.{SharedTorrent, Client}

/**
  * Created by pappmar on 07/03/2016.
  */
object RunDisterTorrent extends App {

  val client = new Client(
    InetAddress.getLocalHost,
    SharedTorrent.fromFile()

  )

}
