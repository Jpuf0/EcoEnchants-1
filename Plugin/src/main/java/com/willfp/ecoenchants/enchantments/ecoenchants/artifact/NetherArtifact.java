package com.willfp.ecoenchants.enchantments.ecoenchants.artifact;

import com.willfp.ecoenchants.enchantments.itemtypes.Artifact;
import org.bukkit.Particle;
public final class NetherArtifact extends Artifact {
    public NetherArtifact() {
        super(
                "nether_artifact"
        );
    }

    @Override
    protected Particle getParticle() {
        return Particle.PORTAL;
    }
}