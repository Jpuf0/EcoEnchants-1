package com.willfp.ecoenchants.nms.API;

import org.bukkit.inventory.ItemStack;

/**
 * NMS Interface for getting/setting anvil repair cost
 */
public interface RepairCostWrapper {
    ItemStack setRepairCost(ItemStack itemStack, int cost);

    int getRepairCost(ItemStack itemStack);
}
