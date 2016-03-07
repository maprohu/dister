package dister

import org.snmp4j.transport.DefaultUdpTransportMapping
import org.snmp4j.{Snmp, PDU, PDUv1, CommunityTarget}
import org.snmp4j.mp.SnmpConstants
import org.snmp4j.smi._

/**
  * Created by martonpapp on 07/03/16.
  */
object ZyxelSnmp extends App {

  // http://www.dslreports.com/forum/r9213492-Getting-WAN-IP-using-snmp
  // snmpwalk -v 1 -c public 192.168.1.1 iso.3.6.1.2.1.4.20.1.1



  val target = new CommunityTarget();
  target.setCommunity(new OctetString("public"));
  target.setAddress(new UdpAddress("192.168.1.1/161"));
  target.setVersion(SnmpConstants.version1);
  target.setTimeout(500)
  target.setRetries(10)

  val pdu = new PDUv1()
  pdu.add(new VariableBinding(new OID("1.3.6.1.2.1.4.20.1.1.0.0.0.0")))
  pdu.setType(PDU.GETNEXT)

  val snmp = new Snmp(new DefaultUdpTransportMapping())
  snmp.listen()
  val response = snmp.send(pdu, target).getResponse

  println(response)

  response.setType(PDU.GETNEXT)
  response.setRequestID(new Integer32(response.getRequestID.toInt+1))

  val res2 = snmp.send(response, target).getResponse
  println(res2)
  res2.setType(PDU.GETNEXT)
  res2.setRequestID(new Integer32(res2.getRequestID.toInt+1))
  val res3 = snmp.send(res2, target).getResponse
  println(res3)

  res3.setType(PDU.GETNEXT)
  res3.setRequestID(new Integer32(res3.getRequestID.toInt+1))
  val res4 = snmp.send(res3, target).getResponse
  println(res4)

}
