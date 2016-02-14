package com.maprohu.dister

import java.io.File

import org.apache.sshd.server.SshServer
import org.apache.sshd.server.auth.password.AcceptAllPasswordAuthenticator
import org.apache.sshd.server.auth.pubkey.AcceptAllPublickeyAuthenticator
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider
import org.apache.sshd.server.shell.ProcessShellFactory

/**
  * Created by martonpapp on 14/02/16.
  */
object Android extends App {

  val keyFile = new File("target/sshd/hostkey.ser")
  keyFile.getParentFile.mkdirs()

  val sshd = SshServer.setUpDefaultServer()
  sshd.setPort(12211)
  sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(keyFile))
  sshd.setPublickeyAuthenticator(AcceptAllPublickeyAuthenticator.INSTANCE)
  sshd.setShellFactory(new ProcessShellFactory(Array("sh", "-i", "-l")))
  sshd.start()

  Thread.sleep(10000000)

}
