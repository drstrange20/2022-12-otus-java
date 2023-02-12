package my.homework.LoggingFramework;

import my.homework.annotation.Log;
import my.homework.service.ConsoleOutputService;
import service.OutputService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoggingFramework {
    private final OutputService outputService = new ConsoleOutputService();

    public void run(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor();
        Method[] allMethods = clazz.getDeclaredMethods();
        List<Method> listOfMethodsWithLogging = getMethodsByAnnotation(allMethods);

        Object object = constructor.newInstance();
        for (Method method : listOfMethodsWithLogging) {
            method.invoke(object);
        }
    }

    private List<Method> getMethodsByAnnotation(Method[] allMethods) {
        return Arrays.stream(allMethods)
                .filter(method -> method.isAnnotationPresent(Log.class))
                .collect(Collectors.toList());
    }
}
