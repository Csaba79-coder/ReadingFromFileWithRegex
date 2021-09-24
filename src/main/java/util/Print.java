package util;

import model.MobileDevice;

import java.util.List;

public class Print {

    public void printMobileDeviceList(List<MobileDevice> mobileDevices) {
        for (MobileDevice mobileDevice : mobileDevices) {
            System.out.println(mobileDevice);
        }
    }
}
