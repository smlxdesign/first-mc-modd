package smlxdesign.burnedcookie

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory


object Main : ModInitializer {
	private val logger = LoggerFactory.getLogger("burnedcookie")

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("LET'S GOOOOOOO!")
		logger.info("I have taken over your computer. If you want to remove virus, please send me £3500 in Google Play gift cards 😊")
		ModItems.initialize()
	}
}
