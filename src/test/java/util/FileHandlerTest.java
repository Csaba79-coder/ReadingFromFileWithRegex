package util;

import config.ConfigReader;
import model.MobileDevice;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileHandlerTest {

    FileHandler fileHandler;

    @Before
    public void init() {
        new FileHandler();
    }

    @Test (expected = NullPointerException.class)
    public void readDevicesIntoListTest() {

        MockedStatic<ConfigReader> configMock = Mockito.mockStatic(ConfigReader.class);
        // they bellow are the same!
        // configMock.when(() -> ConfigReader.getPath()).thenReturn("src/test/resources/regexExample.txt"); // this one is lambda!
        configMock.when(ConfigReader::getPath).thenReturn("src/test/resources/regexExampleTest.txt"); // this one is double colon operator!

        List<MobileDevice> expectedDevices = Arrays.asList(
                new MobileDevice("SM-J510FN"),
                new MobileDevice("Moto G Play"),
                new MobileDevice("SM-A505FN"),
                new MobileDevice("Mi MIX 3")
        );

        assertTrue(compareLists(expectedDevices, fileHandler.readDevicesIntoList()));
        configMock.close();
    }

    @Test (expected = NullPointerException.class)
    public void findDeviceInLineTest() {
        String line = "User-Agent: Pushwize/2.8.0 Dutch+News/9.14.0 Dalvik/2.1.0 (Linux; U; Android 7.1.1; SM-J510FN Build/NMF26X)";

        assertEquals("SM-J510FN", fileHandler.findDeviceInLine(line).getTypeOfDevice());
    }

    private boolean compareLists(List<MobileDevice> expected, List<MobileDevice> actual) {
        if (!(actual != null && expected.size() == actual.size()))
            return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).getTypeOfDevice().equals(actual.get(i).getTypeOfDevice()))
                return false;
        }
        return true;
    }

}