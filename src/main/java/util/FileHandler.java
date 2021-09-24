package util;

import config.ConfigReader;
import model.MobileDevice;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileHandler {

    public List<MobileDevice> mobileDevices = new ArrayList<>();
    ConfigReader configReader = new ConfigReader();
    RegexUtil regexUtil = new RegexUtil();

    public List<MobileDevice> readDevicesIntoList() {
        try {
            Stream<String> lines = Files.lines(Paths.get(configReader.getPath()));
            lines.forEach(line -> {
                MobileDevice currentDevice = findDeviceInLine(line);
                if (currentDevice != null) {
                    mobileDevices.add(currentDevice);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileDevices;
    }

    public MobileDevice findDeviceInLine(String line) {
        String regex = "(?<=Android [7-9].{0,10}; )(.*?)(?= MIUI| Build)";
        String name = regexUtil.findMatch(line, regex);

        if (name != null)
            return new MobileDevice(name);

        return null;
    }
}
