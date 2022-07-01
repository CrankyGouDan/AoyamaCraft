package io.gitee.crankygoudan.AoyamaCraft;

import io.gitee.crankygoudan.AoyamaCraft.Generator.GreenGenerator;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class AoyamaCraft extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // 从您的 config.yml 中读取一些内容

        /*
         * 1. 创建一个新的类别
         * 该类别将使用以下 ItemStack
         */
        ItemStack itemGroupItem = new CustomItemStack(Material.LODESTONE, "&a青山科技","",  "&a> 点击打开 ");
        ItemStack generator = new CustomItemStack(Material.LODESTONE, "&b青山发电机","",  "&a> 点击打开 ");

        // 为您的类别提供一个唯一的 ID。
        NamespacedKey generatorId = new NamespacedKey(this, "qing_shan_generator");
        ItemGroup generatorGroup = new ItemGroup(generatorId, generator);
        NamespacedKey itemGroupId = new NamespacedKey(this, "qing_shan");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, itemGroupItem);

        /*
         * 3. 创建配方
         * 配方是一个长度为 9 的 ItemStack 数组。
         * 它代表 3x3 合成网格中的异形配方。
         * 指定制作此配方的机器
         * 进一步向下作为 RecipeType。
         */
        ItemStack[] greenGeneratorRecipe = {
                new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.OAK_LEAVES),
                new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.OAK_LEAVES),
                new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.OAK_LEAVES), new ItemStack(Material.OAK_LEAVES)
        };

        /*
         * 4. 注册项目
         * 现在您只需注册该项目。
         * RecipeType.ENHANCED_CRAFTING_TABLE 指的是机器
         * 制作此物品的材料。
         * 来自 Slimefun 的配方类型会自动将配方添加到该机器。
         */
        GreenGenerator greenGenerator = new GreenGenerator(generatorGroup, items.GREEN_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, greenGeneratorRecipe);


        greenGenerator.register(this);
        // 我们的项目现已注册

    }

    @Override
    public void onDisable() {
        // 禁用插件的逻辑...
    }

    @Override
    public String getBugTrackerURL() {
        // 您可以在此处返回指向 Bug Tracker 的链接而不是 null
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * 您需要在此处返回对您的插件的引用。
         * 如果您为此使用主类，只需返回“this”。
         */
        return this;
    }

}
