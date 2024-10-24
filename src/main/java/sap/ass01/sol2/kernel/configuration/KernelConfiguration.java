package sap.ass01.sol2.kernel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sap.ass01.sol2.domain.repositories.EBikeRepository;
import sap.ass01.sol2.domain.repositories.RideRepository;
import sap.ass01.sol2.domain.repositories.UserRepository;
import sap.ass01.sol2.kernel.Kernel;
import sap.ass01.sol2.kernel.services.EBikeServicePlugin;
import sap.ass01.sol2.kernel.services.EBikeServicePluginImpl;
import sap.ass01.sol2.kernel.services.RideServicePlugin;
import sap.ass01.sol2.kernel.services.RideServicePluginImpl;
import sap.ass01.sol2.kernel.services.UserServicePlugin;
import sap.ass01.sol2.kernel.services.UserServicePluginImpl;

@Configuration
public class KernelConfiguration {

    @Bean
    public Kernel kernel(EBikeRepository eBikeRepository,
            RideRepository rideRepository,
            UserRepository userRepository) {
        Kernel kernel = new Kernel();

        // Registrazione dei plugin nel kernel
        kernel.registerService(EBikeServicePlugin.class, new EBikeServicePluginImpl(eBikeRepository));
        kernel.registerService(RideServicePlugin.class,
                new RideServicePluginImpl(eBikeRepository, userRepository, rideRepository));
        kernel.registerService(UserServicePlugin.class, new UserServicePluginImpl(userRepository));

        return kernel;
    }
}
