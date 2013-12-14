package se.stagehand

import se.stagehand.plugins.EffectPlugin
import se.stagehand.lib.scripting.Effect
import se.stagehand.plugins.effect.popuptext.PopupText
import se.stagehand.plugins.effect.popuptext.PopupGUI

class ExamplesPlugin extends EffectPlugin {

  val name = "Examples"
  
    
  val guis = List(PopupGUI)
  val effects: Array[Effect] = Array(new PopupText)
  
}