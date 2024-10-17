package sap.ass01.sol2.domain.models;

import java.time.LocalDateTime;

import sap.ass01.sol2.usecases.simulation.RideSimulation;

public class Ride {

    private String rideId;
    private User user;
    private EBike eBike;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double totalDistance;
    private RideSimulation rideSimulation;

    public Ride(String rideId, User user, EBike eBike) {
        this.rideId = rideId;
        this.user = user;
        this.eBike = eBike;
        this.startTime = LocalDateTime.now();
        this.totalDistance = 0.0;
        this.rideSimulation = null;
    }

    public void setRideSimulation(RideSimulation rideSimulation) {
        this.rideSimulation = rideSimulation;
    }

    public RideSimulation getRideSimulation() {
        return rideSimulation;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EBike getEBike() {
        return eBike;
    }

    public void setEBike(EBike eBike) {
        this.eBike = eBike;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void endRide() {
        this.endTime = LocalDateTime.now();
    }

    public void updateDistance(double distance) {
        this.totalDistance += distance;
    }
}