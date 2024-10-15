package sap.ass01.sol1.kernel;

public class Kernel {
    private final ServiceRegistry serviceRegistry;
    private final PluginManager pluginManager;

    public Kernel() {
        this.serviceRegistry = new ServiceRegistry();
        this.pluginManager = new PluginManager();
    }

    public void loadPlugins(String pluginDirectory) {
        pluginManager.loadPluginsFromDirectory(pluginDirectory);
    }

    public <T> T getService(Class<T> serviceClass) {
        T service = serviceRegistry.getService(serviceClass);
        if (service == null) {
            service = pluginManager.getPluginService(serviceClass);
        }
        return service;
    }
}
