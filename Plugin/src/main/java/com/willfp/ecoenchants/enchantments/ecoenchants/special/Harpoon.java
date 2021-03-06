package com.willfp.ecoenchants.enchantments.ecoenchants.special;

import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import com.willfp.ecoenchants.enchantments.util.EnchantChecks;
import com.willfp.ecoenchants.integrations.antigrief.AntigriefManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
public final class Harpoon extends EcoEnchant {
    public Harpoon() {
        super(
                "harpoon", EnchantmentType.SPECIAL
        );
    }

    // START OF LISTENERS

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        if(!event.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY))
            return;

        if(!(event.getCaught() instanceof LivingEntity))
            return;

        Player player = event.getPlayer();

        LivingEntity victim = (LivingEntity) event.getCaught();

        if(victim.hasMetadata("NPC")) return;

        if(!AntigriefManager.canInjure(player, victim)) return;

        if (!EnchantChecks.mainhand(player, this)) return;

        int level = EnchantChecks.getMainhandLevel(player, this);

        double damagePerLevel = this.getConfig().getDouble(EcoEnchants.CONFIG_LOCATION + "damage-per-level");
        double damage = damagePerLevel * level;
        victim.damage(damage, player);
    }
}
