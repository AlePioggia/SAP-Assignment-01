package sap.ass01.sol2.domain.models;

import sap.ass01.sol2.domain.utils.Position;
import sap.ass01.sol2.domain.utils.VelocityVector;

public class EBikeImpl implements EBike {

    private String eBikeId;
    private boolean available;
    private Position position;
    private double speed;
    private VelocityVector direction;

    public EBikeImpl(String eBikeId, Position position, double speed, VelocityVector direction) {
        this.eBikeId = eBikeId;
        this.position = position;
        this.available = true;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public String getEBikeId() {
        return eBikeId;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void markAsAvailable() {
        this.available = true;
    }

    @Override
    public void markAsUnavailable() {
        this.available = false;
    }

    @Override
    public Position getLocation() {
        return position;
    }

    @Override
    public void updateLocation(Position newPosition) {
        this.position = newPosition;
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public void updateSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public VelocityVector getDirection() {
        return direction;
    }

    @Override
    public void updateDirection(VelocityVector direction) {
        this.direction = direction;
    }

}
