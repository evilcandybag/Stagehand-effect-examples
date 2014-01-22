package se.stagehand.plugins.effect.popuptext

import se.stagehand.swing.lib.EffectGUI
import se.stagehand.swing.lib.EditorEffectItem
import se.stagehand.swing.lib.PlayerEffectItem
import se.stagehand.swing.lib.TargetedPlayerEffectItem
import scala.swing.TextField
import scala.swing.Label
import se.stagehand.lib.scripting.Effect
import scala.swing.event.EditDone
import scala.swing.Label

object NetworkedPopupGUI extends EffectGUI {
  val peer = classOf[NetworkedPopupText]
  
  def editorItem(effect: Effect) = new NetworkedPopupEditorItem(checkEffect[NetworkedPopupText](effect))
  def playerItem(effect: Effect) = new NetworkedPopupPlayerItem(checkEffect[NetworkedPopupText](effect))
}

class NetworkedPopupEditorItem(e:NetworkedPopupText) extends TextField("message") with EditorEffectItem[NetworkedPopupText] {
  def effect = e
  text = effect.message
  
  listenTo(this)
  
  reactions += {
    case e:EditDone => {
      effect.message = text
      peer.transferFocusBackward
    }
  }
}

class NetworkedPopupPlayerItem(e:NetworkedPopupText) extends TargetedPlayerEffectItem[NetworkedPopupText](e) {
  def effectItem = new Label("\"" + e.message + "\"")
  refresh
}