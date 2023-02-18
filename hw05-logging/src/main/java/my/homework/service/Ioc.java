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
    public static TestLoggingInterface createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());

        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;
        private final Method[] methods;
        private final OutputService outputService = new ConsoleOutputService();

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
            this.methods = TestLogging.class.getDeclaredMethods();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            List<Method> methodList = Arrays.stream(methods)
                    .filter(method1 -> method1.isAnnotationPresent(Log.class))
                    .toList();
//            if ((methodList.get(0).getName().equals(method.getName())) && (Arrays.equals(methodList.get(0).getParameters(), method.getParameters()))) {
//                outputService.outputMessage(methodList.get(0).getName());
//            }
            if (Arrays.equals(method.getParameters(), methodList.get(0).getParameters())) {
                outputService.outputMessage("1");
            }
/*
            if (method.isAnnotationPresent(Log.class)) {
                outputService.outputMessage("executed method: " + method.getName() + ", params: ");
                for (Object o : args) {
                    System.out.print(o.toString() + " ");
                    System.out.println();
                }
            }
*/
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + myClass +
                    '}';
        }
    }
}