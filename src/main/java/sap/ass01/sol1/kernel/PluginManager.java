
package sap.ass01.sol1.kernel;

import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {
    private final Map<String, Plugin> loadedPlugins = new HashMap<>();

    public void loadPluginsFromDirectory(String pluginDirectory) {
        File dir = new File(pluginDirectory);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid plugin directory: " + pluginDirectory);
        }

        for (File file : dir.listFiles((d, name) -> name.endsWith(".jar"))) {
            try {
                URL[] urls = { file.toURI().toURL() };
                URLClassLoader classLoader = new URLClassLoader(urls);

                for (Class<?> cls : classLoader.loadClass(file.getName().replace(".jar", "")).getClasses()) {
                    if (Plugin.class.isAssignableFrom(cls)) {
                        Plugin plugin = (Plugin) cls.getDeclaredConstructor().newInstance();
                        plugin.initialize();
                        loadedPlugins.put(plugin.getName(), plugin);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T getPluginService(Class<T> serviceClass) {
        for (Plugin plugin : loadedPlugins.values()) {
            if (serviceClass.isAssignableFrom(plugin.getClass())) {
                return serviceClass.cast(plugin);
            }
        }
        return null;
    }
}
