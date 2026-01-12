package at.htl.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class VehicleTest {

    @Test
    void vehicle_createObject_getObject() {
        var opel = new Vehicle("Opel", "Kapitän");
        assertThat(opel.getBrand()).isEqualTo("Opel");
        assertThat(opel.getModel()).isEqualTo("Kapitän");
    }
}