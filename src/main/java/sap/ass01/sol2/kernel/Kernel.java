package sap.ass01.sol2.kernel;

import java.util.HashMap;
import java.util.Map;

public class Kernel {

    private final Map<Class<?>, Object> services = new HashMap<>();

    public <T> void registerService(Class<T> serviceClass, T implementation) {
        services.put(serviceClass, implementation);
    }

    @SuppressWarnings("unchecked")
    public <T> T getService(Class<T> serviceClass) {
        T service = (T) services.get(serviceClass);
        if (service == null) {
            throw new IllegalArgumentException("Service not found: " + serviceClass.getName());
        }
        return service;
    }
}
