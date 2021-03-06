package com.willfp.ecoenchants.enchantments.ecoenchants.normal;

import com.willfp.ecoenchants.EcoEnchantsPlugin;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
public final class Tornado extends EcoEnchant {
    public Tornado() {
        super(
                "tornado", EnchantmentType.NORMAL
        );
    }

    // START OF LISTENERS


    @Override
    public void onMeleeAttack(LivingEntity attacker, LivingEntity victim, int level, EntityDamageByEntityEvent event) {
        double baseVelocity = this.getConfig().getDouble(EcoEnchants.CONFIG_LOCATION + "velocity-per-level");
        double yVelocity = baseVelocity * level;

        Vector toAdd = new Vector(0, yVelocity, 0);

        Bukkit.getScheduler().runTaskLater(EcoEnchantsPlugin.getInstance(), () -> {
            victim.setVelocity(victim.getVelocity().clone().add(toAdd));
        }, 1);
    }
}
