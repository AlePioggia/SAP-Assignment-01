package sap.ass01.sol2.usecases.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sap.ass01.sol2.kernel.Kernel;
import sap.ass01.sol2.kernel.services.EBikeServicePlugin;
import sap.ass01.sol2.kernel.services.RideServicePlugin;
import sap.ass01.sol2.kernel.services.UserServicePlugin;
import sap.ass01.sol2.usecases.AddEBikeUseCase;
import sap.ass01.sol2.usecases.AddUserUseCase;
import sap.ass01.sol2.usecases.GetAllEBikesUseCase;
import sap.ass01.sol2.usecases.GetEBikeUseCase;
import sap.ass01.sol2.usecases.GetUserUseCase;
import sap.ass01.sol2.usecases.RemoveEBikeUseCase;
import sap.ass01.sol2.usecases.StartRideUseCase;
import sap.ass01.sol2.usecases.StopRideUseCase;
import sap.ass01.sol2.usecases.UpdateEBikeUseCase;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public AddEBikeUseCase addEBikeUseCase(Kernel kernel) {
        EBikeServicePlugin eBikeServicePlugin = kernel.getService(EBikeServicePlugin.class);
        return new AddEBikeUseCase(eBikeServicePlugin);
    }

    @Bean
    public StartRideUseCase startRideUseCase(Kernel kernel) {
        RideServicePlugin rideServicePlugin = kernel.getService(RideServicePlugin.class);
        return new StartRideUseCase(rideServicePlugin);
    }

    @Bean
    public AddUserUseCase addUserUseCase(Kernel kernel) {
        UserServicePlugin userServicePlugin = kernel.getService(UserServicePlugin.class);
        return new AddUserUseCase(userServicePlugin);
    }

    @Bean
    public GetAllEBikesUseCase getAllEBikesUseCase(Kernel kernel) {
        EBikeServicePlugin eBikeServicePlugin = kernel.getService(EBikeServicePlugin.class);
        return new GetAllEBikesUseCase(eBikeServicePlugin);
    }

    @Bean
    public GetEBikeUseCase getEBikeUseCase(Kernel kernel) {
        EBikeServicePlugin eBikeServicePlugin = kernel.getService(EBikeServicePlugin.class);
        return new GetEBikeUseCase(eBikeServicePlugin);
    }

    @Bean
    public GetUserUseCase getUserUseCase(Kernel kernel) {
        UserServicePlugin userServicePlugin = kernel.getService(UserServicePlugin.class);
        return new GetUserUseCase(userServicePlugin);
    }

    @Bean
    public RemoveEBikeUseCase removeEBikeUseCase(Kernel kernel) {
        EBikeServicePlugin eBikeServicePlugin = kernel.getService(EBikeServicePlugin.class);
        return new RemoveEBikeUseCase(eBikeServicePlugin);
    }

    @Bean
    public StopRideUseCase stopRideUseCase(Kernel kernel) {
        RideServicePlugin rideServicePlugin = kernel.getService(RideServicePlugin.class);
        return new StopRideUseCase(rideServicePlugin);
    }

    @Bean
    public UpdateEBikeUseCase updateEBikeUseCase(Kernel kernel) {
        EBikeServicePlugin eBikeServicePlugin = kernel.getService(EBikeServicePlugin.class);
        return new UpdateEBikeUseCase(eBikeServicePlugin);
    }
}
