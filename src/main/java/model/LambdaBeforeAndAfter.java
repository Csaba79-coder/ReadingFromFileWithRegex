package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaBeforeAndAfter {

    public void runLambda() {
        List<String> stringList = Arrays.asList("a", "b", "c");

        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).equals("a")) {
                System.out.println("yes");
            }
            System.out.println(stringList.get(i));
        }
        for (String element : stringList) {
            if (element.equals("a")) {
                System.out.println("yes");
            }
            System.out.println(element);
        }
        stringList.forEach(element -> {
            if (element.equals("a")) {
                System.out.println("yes");
            }
            System.out.println(element);
        });
        stringList.forEach(System.out::println);

        Map<String, MobileDevice> mapList = new HashMap<>();
        mapList.put("first", new MobileDevice("Samsung"));
        mapList.put("second", new MobileDevice("I-Phone"));

        mapList.forEach((key, value) -> {
            if (key.equals("first") && value.getTypeOfDevice().equals("second")) {
                System.out.println("yes");
            }
            System.out.println(key);
            System.out.println(value);
        });
        // with own names!
        mapList.forEach((name, device) -> {
            if (name.equals("first") && device.getTypeOfDevice().equals("second")) {
                System.out.println("yes");
            }
            System.out.println(name);
            System.out.println(device);
        });

        switch (stringList.get(1)) {
            case "a" -> System.out.println(stringList.get(1));
            case "b" -> System.out.println("no");
        }
    }
}
