package com.rjf;

import com.thoughtworks.xstream.XStream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * An {@link Aspect} that hooks the {@link XStream} constructor, to initialise security.
 *
 * @author rjf
 * @version $Id: %I% %G%
 */
@Aspect
public class XStreamCreationAspect {
    @AfterReturning(value = "execution(public com.thoughtworks.xstream.XStream.new(..))")
    public void after(final JoinPoint joinPoint) {
        System.out.printf("Executed:   %s%n", joinPoint.getSignature());
        System.out.printf("Returned:   %s%n", joinPoint.getThis());
        System.out.printf("Static:     %s%n", joinPoint.getStaticPart().getSourceLocation().getWithinType());
        System.out.printf("Target:     %s%n", joinPoint.getTarget());
        System.out.println();
    }
}