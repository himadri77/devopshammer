package com.smartdevs.interceptor;

import com.smartdevs.annotation.MaxInputLengthValidator;
import com.smartdevs.exception.InputLengthException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.logging.Logger;

/**
 * Created by johnnym on 30/05/15.
 */
public class InputLengthInterceptor implements MethodInterceptor {
    private static Logger LOGGER = Logger.getLogger(InputLengthInterceptor.class.getName());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (invocation.getArguments().length < 1 || !(invocation.getArguments()[0] instanceof String)) {
            LOGGER.warning("The first argument of the annotated method MUST be a String at " + invocation.getMethod().toGenericString());
            return invocation.proceed();
        }

        int limit = invocation.getMethod().getAnnotation(MaxInputLengthValidator.class).value();
        int size = ((String) invocation.getArguments()[0]).length();

        if (size > limit) {
            throw new InputLengthException("Input size (" + size + ") exceeds limit (" + limit + ")!");
        }
        return invocation.proceed();
    }
}
