package ben.plugins.helloWorldPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  @Override
  public void onEnable() {

  }

  @Override
  public void onDisable() {

  }

  // user types in console "/hello" console prints "Hello, world!"
  public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {

    if (label.equalsIgnoreCase("helloplayer")) {
      if (snd instanceof Player) {
        // if it's a player, have give them a hello!
        Player player = (Player) snd;
        if (player.hasPermission("helloplayer.use")) {
          player.sendMessage(
              ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Hello, " + player.getName() + "!");
          player.sendMessage("Here are some fancy pants!");
          player.getInventory().addItem(givePants());
          return true;
        }
        player
            .sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You do not have permission!");
      } else {
        // say hello to console
        snd.sendMessage("Hello, console!");
      }
    }

    return false;
  }

  public ItemStack givePants() {

    ItemStack pants = new ItemStack(Material.LEATHER_LEGGINGS);
    ItemMeta meta = pants.getItemMeta();

    meta.setDisplayName("Fancy pants");
    meta.addEnchant(Enchantment.DURABILITY, 42, true);

    pants.setItemMeta(meta);

    return pants;

  }

}
