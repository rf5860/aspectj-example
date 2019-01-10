package com.rjf;

import com.rf5860.XStreamArgumentsProvider_InvalidPackage;
import com.thoughtworks.xstream.XStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class XStreamCreationAspectTest {
    // TODO: Actually test something - for now, the aspect just logs to stdout.

    /**
     * To test that AspectJ <strong>is</strong> triggered when the package is not <pre>com.rjf</pre>
     */
    @ParameterizedTest(name = "Testing new XStream{arguments}")
    @ArgumentsSource(XStreamArgumentsProvider_ValidPackage.class)
    public void testXStreamConstructorAspect_ValidPackage(final XStream stream) {
        // This one should call the AspectJ advice method.
    }

    /**
     * To test that AspectJ is <strong>not</strong> triggered when the package is not <pre>com.rjf</pre>
     */
    @ParameterizedTest(name = "Testing new XStream{arguments}")
    @ArgumentsSource(XStreamArgumentsProvider_InvalidPackage.class)
    public void testXStreamConstructorAspect_InvalidPackage(final XStream stream) {
        // This one should not call the AspectJ advice method.
    }

}