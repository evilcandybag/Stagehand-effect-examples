package se.stagehand.plugins.effect.popuptext

import se.stagehand.lib.scripting._
import scala.xml.Node
import scala.swing._

class PopupText(id:Int) extends Effect(id) {
  def this() = this(ID.unique)
  def componentName = "PopupText"
    
  var message = "message"
    
    
  def trigger {
    Dialog.showMessage(null, message, "PopupText", Dialog.Message.Plain )
  }

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