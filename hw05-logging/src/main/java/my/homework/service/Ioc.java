package my.homework.service;


import my.homework.annotation.Log;
import service.ReportService;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;


public class Ioc {
    private Ioc() {
    }

    public static Object createMyClass(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();

        List<String> methodList = createListOfMethodsWithLogAnnotation(clazz);
        InvocationHandler handler = new DemoInvocationHandler(object, methodList);

        return Proxy.newProxyInstance(Ioc.class.getClassLoader(), new Class<?>[]{clazz.getInterfaces()[0]}, handler);
    }

    private static List<String> createListOfMethodsWithLogAnnotation(Class<?> clazz) {
        return Arrays
                .stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Log.class))
                .map(method -> method.getName() + Arrays.toString(method.getGenericParameterTypes()))
                .toList();
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final Object object;
        private final List<String> methodList;
        private final ReportService outputService = new ConsoleOutputService();

        DemoInvocationHandler(Object object, List<String> methodList) {
            this.object = object;
            this.methodList = methodList;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            if (methodList.contains(methodName + Arrays.toString(method.getGenericParameterTypes()))) {
                outputService.printReport(methodName, Arrays.toString(args));
            }
            return method.invoke(object, args);
        }
    }
}