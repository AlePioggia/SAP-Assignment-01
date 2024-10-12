package sap.ass01.sol1.service.utils;

public class VelocityVector {
    private double x;
    private double y;

    public VelocityVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public VelocityVector mul(double scalar) {
        return new VelocityVector(x * scalar, y * scalar);
    }

    public VelocityVector normalize() {
        double length = Math.sqrt(x * x + y * y);
        return new VelocityVector(x / length, y / length);
    }

    public VelocityVector rotate(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        double cosTheta = Math.cos(angleRadians);
        double sinTheta = Math.sin(angleRadians);
        return new VelocityVector(
                x * cosTheta - y * sinTheta,
                x * sinTheta + y * cosTheta);
    }
}