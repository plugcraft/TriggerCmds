package com.SySammy.triggercmds;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

class tListener extends PlayerListener
{
  tCmds plugin;
  private Methods Methods;

  public tListener(tCmds aThis)
  {
    this.plugin = aThis;
  }

  public void onPlayerInteract(PlayerInteractEvent event)
  {
    if ((event.getAction().equals(Action.LEFT_CLICK_BLOCK)) && (
      (event.getClickedBlock().getType().equals(Material.STONE_BUTTON)) || (event.getClickedBlock().getType().equals(Material.LEVER)))) {
      Player p = event.getPlayer();
      Location loc = event.getClickedBlock().getLocation();
      this.Methods = new Methods(this.plugin);
      if (this.plugin.iNames.containsKey(p)) {
        this.Methods.RegLocation(p, loc);
        return;
      }if (this.plugin.Cmds.containsKey(loc))
        this.Methods.ExecuteCmd(p, loc);
    }
  }
}