package module;

import model.LambdaBeforeAndAfter;
import model.MobileDevice;
import util.FileHandler;
import util.Print;

import java.util.List;

public class Processor {

    public void run() {

        Print print = new Print();

        String copyWrite = new CopyRight().addingCopyright();
        print.printString(copyWrite);

        List<MobileDevice> mobileDevices = new FileHandler().readDevicesIntoList();
        print.printMobileDeviceList(mobileDevices);

        System.out.println("----------------Lambda-----------------");

        new LambdaBeforeAndAfter().runLambda();
    }
}
