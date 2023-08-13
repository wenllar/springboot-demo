package org.springboot.selector;

import org.springboot.config.AutoConfiguration;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.*;

public class WenllarImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        ServiceLoader<AutoConfiguration> serviceLoader = ServiceLoader.load(AutoConfiguration.class);

        List<String> list = new ArrayList<>();
        for (AutoConfiguration configuration : serviceLoader) {
            list.add(configuration.getClass().getName());
        }
        return list.toArray(new String[0]);
    }
}
