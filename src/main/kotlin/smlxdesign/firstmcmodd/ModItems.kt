package smlxdesign.firstmcmodd

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import java.util.function.Function

class ModItems {
    fun register(name: String, itemFactory: Function<Item.Settings, Item>, settings: Item.Settings): Item {
        val itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("smlxdesign.first-mc-modd", name))
        val item = itemFactory.apply(settings.registryKey(itemKey))
        Registry.register(Registries.ITEM, itemKey, item)

        return item
    }
}