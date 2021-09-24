package module;

import model.MobileDevice;
import util.FileHandler;
import util.Print;

import java.util.List;

public class Processor {

    public void run() {

        List<MobileDevice> mobileDevices = new FileHandler().readDevicesIntoList();
        new Print().printMobileDeviceList(mobileDevices);
    }
}
