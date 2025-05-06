package smlxdesign.firstmcmodd

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import java.util.function.Function

class ModItems {
	fun register(
		name: String,
		itemFactory: Function<Item.Settings, Item>,
		settings: Item.Settings
	): Item {
		val itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("smlxdesign.first-mc-modd", name))
		val item = itemFactory.apply(settings.registryKey(itemKey))
		Registry.register(Registries.ITEM, itemKey, item)

		return item
	}

	fun initialize() {
		// TODO: https://docs.fabricmc.net/develop/items/first-item#adding-the-item-to-an-item-group
		// 	Add it to a group, so you can see the item in-game.
	}

	val BURNED_COOKIE: Item? =
		register("burned_cookie", { settings: Item.Settings? -> Item(settings) }, Item.Settings())
}
