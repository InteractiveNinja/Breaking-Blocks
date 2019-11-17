package com.senpai.breakingblocks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements CommandExecutor,Listener{

	public static String PLUGINNAME = ChatColor.BLUE+"[Breaking Blocks]";
	public static boolean activ = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void onEnable() {

		System.out.println(PLUGINNAME + "Aktiv");
		this.getCommand("who").setExecutor(new senpai());
		this.getCommand("blocks").setExecutor(new blocks());
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		System.out.println(PLUGINNAME + "Deaktiviert");
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
    
		
		if(activ) {
			
			if((int)(Math.random()*10)+1 == 10) {
			LivingEntity s;
			Player p = event.getPlayer();
			p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 1f, 1f);
			ItemStack item = new ItemStack(event.getBlock().getType());
			ItemMeta m = item.getItemMeta();
			m.addEnchant(Enchantment.KNOCKBACK, 20, true);
			m.addEnchant(Enchantment.DAMAGE_ALL, 3,true);
			item.setItemMeta(m);
			s = (LivingEntity) p.getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.ZOMBIE);
			s.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,5000, 1,true));
			s.getEquipment().setHelmet(new ItemStack(event.getBlock().getType()));
			s.getEquipment().setHelmetDropChance(0f);
			s.getEquipment().setItemInMainHand(item);
			s.getEquipment().setItemInMainHandDropChance(0f);
			
			}
		}
	
		
	
	}
}
