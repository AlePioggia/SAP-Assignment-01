package sap.ass01.sol1.kernel;

public class Kernel {
    private final ServiceRegistry serviceRegistry;
    private final PluginManager pluginManager;

    public Kernel() {
        this.serviceRegistry = new ServiceRegistry();
        this.pluginManager = new PluginManager();
    }

    public ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public <T> T getService(Class<T> serviceClass) {
        T service = serviceRegistry.getService(serviceClass);
        if (service == null) {
            service = pluginManager.getPluginService(serviceClass);
        }
        return service;
    }
}
