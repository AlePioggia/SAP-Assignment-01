
package sap.ass01.sol1.kernel;

import java.util.HashMap;
import java.util.Map;

public class PluginManager {
    private final Map<Class<?>, Object> pluginServices = new HashMap<>();

    public <T> void registerPlugin(Class<T> serviceClass, T pluginService) {
        pluginServices.put(serviceClass, pluginService);
    }

    @SuppressWarnings("unchecked")
    public <T> T getPluginService(Class<T> serviceClass) {
        return (T) pluginServices.get(serviceClass);
    }

    public <T> void unregisterPlugin(Class<T> serviceClass) {
        pluginServices.remove(serviceClass);
    }
}
