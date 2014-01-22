package se.stagehand.plugins.effect.popuptext

import se.stagehand.lib.scripting.network.NetworkedEffect
import se.stagehand.lib.scripting.ID
import scala.swing.Dialog
import scala.xml.Node
import se.stagehand.lib.Log
import se.stagehand.lib.scripting.network.Capabilities

class NetworkedPopupText(id:Int) extends NetworkedEffect(id) {
  def this() = this(ID.unique)
  
  def componentName = "NetworkedPopupText"
  
  def runArgs = {
    Map(Capabilities.SIMPLE_TEXT -> message)
  }
  
  def requirements = Set(Capabilities.SIMPLE_TEXT)

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