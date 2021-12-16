package com.restl6sergey.restApplication;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "public", catalog = "ShowroomTest")
public class CarEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="car_seq")
    @SequenceGenerator(name="car_seq",
            sequenceName="car_id_seq", allocationSize=1)
    @Column(name = "car_id")
    private int carId;
    @Basic
    @Column(name = "complectation")
    private String complectation;
    @Basic
    @Column(name = "engine")
    private float engine;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private Float price;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "year")
    private int year;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }


    public String getComplectation() {
        return complectation;
    }

    public void setComplectation(String complectation) {
        this.complectation = complectation;
    }

    public float getEngine() {
        return engine;
    }

    public void setEngine(float engine) {
        this.engine = engine;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return carId == carEntity.carId && Float.compare(carEntity.engine, engine) == 0 && year == carEntity.year && Objects.equals(complectation, carEntity.complectation) && Objects.equals(model, carEntity.model) && Objects.equals(name, carEntity.name) && Objects.equals(price, carEntity.price) && Objects.equals(quantity, carEntity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, complectation, engine, model, name, price, quantity, year);
    }
}
