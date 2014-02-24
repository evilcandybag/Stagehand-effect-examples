package se.stagehand.plugins.effect.popuptext

import se.stagehand.lib.network.EffectServer
import se.stagehand.lib.network.AbstractWorker
import scala.collection.JavaConversions.asJavaMap
import se.stagehand.lib.scripting.Target
import akka.actor.Props
import se.stagehand.lib.scripting.network.NetworkedEffect
import se.stagehand.lib.scripting.network.Capabilities
import scala.swing.Dialog

object PopupServer extends EffectServer {
  def defaultName = "PopupServer"
  def properties = {
    val caps = (NetworkedEffect.CAPABILITIES, Capabilities.SIMPLE_TEXT)
    val desc = (NetworkedEffect.DESCRIPTION, "Server providing viewing of simple text by means of a popup window.")
    Map[String,String](caps,desc)
  }
  
  
  
  
  val worker = new PopupWorker
}

class PopupWorker extends AbstractWorker(PopupServer) {
  import Target.Protocol
  
  def received(args: Protocol.Arguments) {
    args.get(Capabilities.SIMPLE_TEXT) match {
      case Some(message) => {
        Dialog.showMessage(null, message, "Networked Popup Text", Dialog.Message.Plain )
      }
      case None => log.error("Message contained no parameter named \"simpleText\": " + args)
    }
  }
}