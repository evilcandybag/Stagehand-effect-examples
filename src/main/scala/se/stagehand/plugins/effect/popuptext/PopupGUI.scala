package se.stagehand.plugins.effect.popuptext

import se.stagehand.swing.lib.EffectGUI
import se.stagehand.swing.lib.EditorEffectItem
import se.stagehand.swing.lib.PlayerEffectItem
import scala.swing.TextField
import scala.swing.Label
import se.stagehand.lib.scripting.Effect

object PopupGUI extends EffectGUI {
  val peer = classOf[PopupText]
  
  def editorItem(effect: Effect) = new PopupEditorItem(checkEffect[PopupText](effect))
  def playerItem(effect: Effect) = new PopupPlayerItem(checkEffect[PopupText](effect))
}

class PopupEditorItem(e:PopupText) extends TextField with EditorEffectItem[PopupText] {
  def effect = e
}

class PopupPlayerItem(e:PopupText) extends Label with PlayerEffectItem[PopupText] {
  def effect = e
}