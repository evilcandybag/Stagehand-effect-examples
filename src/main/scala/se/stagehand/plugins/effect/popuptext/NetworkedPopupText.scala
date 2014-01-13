package se.stagehand.plugins.effect.popuptext

import se.stagehand.lib.scripting.network.NetworkedEffect
import se.stagehand.lib.scripting.ID
import scala.swing.Dialog
import scala.xml.Node
import se.stagehand.lib.Log

class NetworkedPopupText(id:Int) extends NetworkedEffect(id) {
  def this() = this(ID.unique)
  val log = Log.getLog(this.getClass())
  
  def componentName = "NetworkedPopupText"
  
  def runArgs = {
    Map("text" -> message)
  }
  
  override def trigger {
    log.debug("Effect triggered")
    super.trigger
  }

  var message = "message"
    

  override def readInstructions(in:Node) {
    super.readInstructions(in)
    message = (in \\ "message").text
  }
  override def generateInstructions = {
    implicit var xml = super.generateInstructions
    xml = addChild(<message>{message}</message>)
    
    xml
  }
}