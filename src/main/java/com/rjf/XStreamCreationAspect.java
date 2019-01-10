package com.rjf;

import com.thoughtworks.xstream.XStream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * An {@link Aspect} that hooks the {@link XStream} constructor, to initialise security.
 *
 * @author rjf
 * @version $Id: %I% %G%
 */
@Aspect
public class XStreamCreationAspect {
    /**
     * The use of `call` may be marked as an error in IntelliJ.
     * <br>
     * This is because IntelliJ doesn't fully support "AspectJ".
     * <br>
     * Pointcut for all Constructor calls to {@link XStream}, regardless of arguments.
     */
    @Pointcut(value = "call(public com.thoughtworks.xstream.XStream.new(..))")
    public void onXStreamCreation() { }

    /**
     * Pointcut for code called from classes in the package <pre>com.rjf</pre>
     */
    @Pointcut(value = "within(com.rjf..*)")
    public void fromWithinSpecificPackage() { }


    /**
     * Advice to be called after method execution.
     * <br>
     * Matches the following pointcuts:
     * <ul>
     *     <li>Constructor calls of {@link XStream}</li>
     *     <li>Code called within the package (and sub-packages) of <pre>com.rjf</pre></li>
     * </ul>
     *
     * @param joinPoint runtime details of the current joinpoint
     */
    @AfterReturning(value = "onXStreamCreation() && fromWithinSpecificPackage()")
    public void after(final JoinPoint joinPoint) {
        System.out.printf("Executed:   %s%n", joinPoint.getSignature());
        System.out.printf("Returned:   %s%n", joinPoint.getThis());
        System.out.printf("Static:     %s%n", joinPoint.getStaticPart().getSourceLocation().getWithinType());
        System.out.printf("Target:     %s%n", joinPoint.getTarget());
        System.out.println();
    }
}