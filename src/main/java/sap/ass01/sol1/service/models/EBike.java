package sap.ass01.sol1.service.models;

import sap.ass01.sol1.service.utils.Position;
import sap.ass01.sol1.service.utils.VelocityVector;

public interface EBike {
    public String getEBikeId();

    public boolean isAvailable();

    public void setAvailable(boolean available);

    public void markAsAvailable();

    public void markAsUnavailable();

    Position getLocation();

    void updateLocation(Position newPosition);

    double getSpeed();

    void updateSpeed(double speed);

    VelocityVector getDirection();

    void updateDirection(VelocityVector direction);
}
