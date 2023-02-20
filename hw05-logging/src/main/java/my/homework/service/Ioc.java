package my.homework.service;


import my.homework.annotation.Log;
import service.OutputService;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;


public class Ioc {
    private static List<Method> methods;

    public static void setMethods(List<Method> methods) {
        Ioc.methods = methods;
    }

    public static List<Method> getMethods() {
        return methods;
    }

    public static Object createMyClass(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        setMethods(Arrays
                .stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Log.class))
                .toList());

        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        InvocationHandler handler = new DemoInvocationHandler(object);

        return Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{clazz.getInterfaces()[0]}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final Object object;
        private final OutputService outputService = new ConsoleOutputService();

        DemoInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for (Method method1 : getMethods()) {
                if (Arrays.equals(method1.getGenericParameterTypes(), method.getGenericParameterTypes()) && method1.getName().equals(method.getName())) {
                    outputService.outputMessage("executed method: " + method.getName() + ", params: " + Arrays.toString(args));
                }
            }
            return method.invoke(object, args);
        }
    }
}