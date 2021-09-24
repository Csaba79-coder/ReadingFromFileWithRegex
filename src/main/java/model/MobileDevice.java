package model;

public class MobileDevice {

    String typeOfDevice;

    public MobileDevice() {
    }

    public MobileDevice(String typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    public String getTypeOfDevice() {
        return typeOfDevice;
    }

    public void setTypeOfDevice(String typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    @Override
    public String toString() {
        return typeOfDevice.trim().toString();
    }
}
