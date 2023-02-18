package my.homework.service;


import my.homework.annotation.Log;
import my.homework.api.service.TestLoggingInterface;
import service.OutputService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;


public class Ioc {
    private static final List<Method> METHODS = Arrays
            .stream(TestLogging.class.getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(Log.class)).toList();

    public static TestLoggingInterface createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());

        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;
        private final OutputService outputService = new ConsoleOutputService();

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for (Method method1 : METHODS) {
                if (Arrays.equals(method1.getGenericParameterTypes(), method.getGenericParameterTypes()) && method1.getName().equals(method.getName())) {
                    outputService.outputMessage("executed method: " + method.getName() + ", params: " + Arrays.toString(args));
                }
            }
            return method.invoke(myClass, args);
        }
    }
}