package sap.ass01.sol1.service.models;

import sap.ass01.sol1.service.utils.Position;

public interface EBike {
    public String getEBikeId();

    public boolean isAvailable();

    public void setAvailable(boolean available);

    public void markAsAvailable();

    public void markAsUnavailable();

    public Position getPosition();

    public void setPosition(Position position);
}
