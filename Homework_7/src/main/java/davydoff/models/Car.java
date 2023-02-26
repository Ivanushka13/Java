package davydoff.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Model-class with some fields for testing program.
 */
public final class Car {

    @JsonProperty
    private final String carName;

    @JsonProperty
    private final String engine;

    @JsonProperty
    private final String color;

    @JsonProperty
    private final int yearCreation;

    public Car(String carName, String engine, String color, int yearCreation) {
        this.carName = carName;
        this.engine = engine;
        this.color = color;
        this.yearCreation = yearCreation;
    }

    public String getCarName() {
        return carName;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public int getYearCreation() {
        return yearCreation;
    }
}
