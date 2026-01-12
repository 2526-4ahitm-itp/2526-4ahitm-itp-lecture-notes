package at.htl.control;

import at.htl.entity.Vehicle;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.assertj.db.type.AssertDbConnectionFactory;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class VehicleRepositoryTest {

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    AgroalDataSource ds;

    @TestTransaction
    @Test
    void persist_persistNewVehicle_vehicleInDb() {
        var conn = AssertDbConnectionFactory.of(ds).create();

        //given
        var opel = new Vehicle("Opel", "Senator");
        var vehicleTable = conn.table("VEHICLE").build();
        output(vehicleTable).toConsole();

        //when
        vehicleRepository.persist(opel);

        //then
        vehicleTable = conn.table("VEHICLE").build();
        output(vehicleTable).toConsole();

        assertThat(vehicleTable).hasNumberOfRows(1);

    }
}