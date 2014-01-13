package se.stagehand

import se.stagehand.plugins.EffectPlugin
import se.stagehand.lib.scripting.Effect
import se.stagehand.plugins.effect.popuptext.PopupText
import se.stagehand.plugins.effect.popuptext.PopupGUI
import se.stagehand.plugins.effect.popuptext.NetworkedPopupText
import se.stagehand.plugins.effect.popuptext.NetworkedPopupGUI

class ExamplesPlugin extends EffectPlugin {

  val name = "Examples"
  
    
  val guis = List(PopupGUI, NetworkedPopupGUI)
  val effects: Array[Effect] = Array(new PopupText, new NetworkedPopupText)
  
}