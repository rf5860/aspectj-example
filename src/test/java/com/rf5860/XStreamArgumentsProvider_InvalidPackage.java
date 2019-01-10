package com.rf5860;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.DefaultConverterLookup;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.DefaultMapper;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class XStreamArgumentsProvider_InvalidPackage implements ArgumentsProvider {
    private static final PureJavaReflectionProvider reflectionProvider = new PureJavaReflectionProvider();
    private static final ClassLoader classLoader = XStream.class.getClassLoader();
    private static final ClassLoaderReference classLoaderRef = new ClassLoaderReference(classLoader);
    private static final DefaultMapper mapper = new DefaultMapper(classLoaderRef);
    private static final StaxDriver driver = new StaxDriver();
    private static final DefaultConverterLookup converter = new DefaultConverterLookup();

    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext context) {
        return Stream.of(new XStream(driver),
                         new XStream(reflectionProvider),
                         new XStream(reflectionProvider, driver),
                         new XStream(reflectionProvider, mapper, driver),
                         new XStream(reflectionProvider, driver, classLoader),
                         new XStream(reflectionProvider, driver, classLoader, mapper),
                         new XStream(reflectionProvider, driver, classLoader, mapper, converter, converter),
                         new XStream(reflectionProvider, driver, classLoaderRef),
                         new XStream(reflectionProvider, driver, classLoaderRef, mapper),
                         new XStream(reflectionProvider, driver, classLoaderRef, mapper, converter, converter),
                         new XStream()).map(Arguments::of);
    }
}
