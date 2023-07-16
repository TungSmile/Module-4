package com.example.Config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class ApplicationInitianlizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }


    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
