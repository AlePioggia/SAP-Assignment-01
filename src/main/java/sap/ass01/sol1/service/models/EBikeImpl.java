package sap.ass01.sol1.service.models;

import sap.ass01.sol1.service.utils.Position;

public class EBikeImpl implements EBike {

    private String eBikeId;
    private boolean available;
    private Position position;

    public EBikeImpl(String eBikeId, Position position) {
        this.eBikeId = eBikeId;
        this.position = position;
        this.available = true;
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
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

}
