package com.SySammy.triggercmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands
  implements CommandExecutor
{
  tCmds plugin;
  private Methods Methods;

  public Commands(tCmds aThis)
  {
    this.plugin = aThis;
  }

  public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings)
  {
    String[] args = strings;
    String cmd = cmnd.getName().toLowerCase();
    if (cmd.equals("tcmds")) {
      return BrokenMethod(cs, args);
    }
    return true;
  }

  private boolean BrokenMethod(CommandSender cs, String[] arg) {
    Player p = (Player)cs;
    try {
      if (!this.plugin.casUseTriggerCmds(p)) {
        p.sendMessage(ChatColor.RED + "You don't have permisson to use that command");
        return true;
      }
      if (arg.length <= 0) {
        p.sendMessage(ChatColor.GOLD + "[ " + ChatColor.GREEN + "TriggerCmds Help Page" + ChatColor.GOLD + " ]");
        p.sendMessage(ChatColor.GOLD + "LeftClick" + ChatColor.WHITE + " - Reg Trigger Link ");
        p.sendMessage(ChatColor.GOLD + "RightClick" + ChatColor.WHITE + " - Del Trigger Link");
        return false;
      }if (arg[0].equalsIgnoreCase("list")) {
        this.Methods = new Methods(this.plugin);
        this.Methods.iList(p);
        return true;
      }if (arg[0].equalsIgnoreCase("edit")) {
        this.Methods = new Methods(this.plugin);
        this.Methods.RegEditInteraction(p, arg[1].toLowerCase());
        return true;
      }if (arg[0].equalsIgnoreCase("cmd")) {
        this.Methods = new Methods(this.plugin);
        String GetCmds = this.Methods.GetCmds(p.getName(), arg);
        this.Methods.RegCmd(p, GetCmds);
        return true;
      }if (arg[0].equalsIgnoreCase("del")) {
        this.Methods = new Methods(this.plugin);
        this.Methods.delTrigger(p);
        return true;
      }if (arg[0].equalsIgnoreCase("help")) {
        p.sendMessage(ChatColor.GOLD + "[ " + ChatColor.GREEN + "TriggerCmds Help Page" + ChatColor.GOLD + " ]");
        p.sendMessage(ChatColor.GOLD + "LeftClick" + ChatColor.WHITE + " - Reg Trigger Link ");
        p.sendMessage(ChatColor.GOLD + "RightClick" + ChatColor.WHITE + " - Del Trigger Link");
        return false;
      }
      p.sendMessage(ChatColor.GOLD + "[ " + ChatColor.GREEN + "TriggerCmds Help Page" + ChatColor.GOLD + " ]");
      p.sendMessage(ChatColor.GOLD + "LeftClick" + ChatColor.WHITE + " - Reg Trigger Link ");
      p.sendMessage(ChatColor.GOLD + "RightClick" + ChatColor.WHITE + " - Del Trigger Link");
      return false;
    } catch (Exception e) {
      p.sendMessage(ChatColor.RED + "Input error, please try again.");
      p.sendMessage(ChatColor.GOLD + "[ " + ChatColor.GREEN + "TriggerCmds Help Page" + ChatColor.GOLD + " ]");
    }return false;
  }
}