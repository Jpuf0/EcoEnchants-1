package com.willfp.ecoenchants.enchantments.ecoenchants.normal;

import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchantBuilder;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import com.willfp.ecoenchants.enchantments.util.checks.EnchantChecks;
import com.willfp.ecoenchants.nms.Target;
import com.willfp.ecoenchants.nms.TridentStack;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Conclude extends EcoEnchant {
    public Conclude() {
        super(
                new EcoEnchantBuilder("conclude", EnchantmentType.NORMAL, Target.Applicable.TRIDENT, 4.0)
        );
    }

    // START OF LISTENERS

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Trident))
            return;
        if (!(event.getEntity() instanceof LivingEntity))
            return;

        Trident trident = (Trident) event.getDamager();
        ItemStack item = TridentStack.getTridentStack(trident);
        LivingEntity victim = (LivingEntity) event.getEntity();

        if (!EnchantChecks.item(item, this)) return;
        int level = EnchantChecks.getItemLevel(item, this);

        double minhealth = this.getConfig().getDouble(EcoEnchants.CONFIG_LOCATION + "minimum-health-per-level");
        if (!(victim.getHealth() <= level * minhealth))
            return;

        event.setDamage(10000); // cba to do this properly
    }
}