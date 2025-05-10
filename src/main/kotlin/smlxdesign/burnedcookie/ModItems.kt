package smlxdesign.firstmcmodd

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.component.type.ConsumableComponents
import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.consume.ApplyEffectsConsumeEffect
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import java.util.function.Function

class ModItems {
	companion object {
		fun register(
			name: String, itemFactory: Function<Item.Settings, Item>, settings: Item.Settings
		): Item {
			val itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("burnedcookie", name))
			val item = itemFactory.apply(settings.registryKey(itemKey))
			Registry.register(Registries.ITEM, itemKey, item)

			return item
		}

		fun initialize() {
			ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
				.register(ModifyEntries { itemGroup: FabricItemGroupEntries? -> itemGroup?.add(BURNED_COOKIE) })
		}

		val BURNED_COOKIE: Item = register(
			"burned_cookie", { settings: Item.Settings? -> Item(settings) }, Item.Settings().food(
				FoodComponent.Builder().nutrition(1).build(),
				ConsumableComponents.food()
					.consumeEffect(ApplyEffectsConsumeEffect(StatusEffectInstance(StatusEffects.POISON, 200))).build()
			)
		)
	}
}
