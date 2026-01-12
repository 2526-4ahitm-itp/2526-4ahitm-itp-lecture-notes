package at.htl.control;

import at.htl.entity.Vehicle;
import io.quarkus.logging.Log;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.configuration.ConfigUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    VehicleRepository vehicleRepository;

    @Startup
    @Transactional
    void init() {
        if (ConfigUtils.getProfiles().contains("dev")) {
            Log.info("================");
            Log.info("InitBean started");
            Log.info("================");

            Vehicle opel = new Vehicle("Opel", "Blitz");

            vehicleRepository.persist(opel);
        }
    }

}
