package ataraszkiewicz;

import ataraszkiewicz.config.MongoConfig;
import ataraszkiewicz.config.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author ataraszkiewicz
 * @since 2015-08-31
 */
public class Application implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MongoConfig.class, WebMvcConfig.class);

        ServletRegistration.Dynamic dynamc = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webApplicationContext));
        dynamc.addMapping("/api/v1/*");
        dynamc.setLoadOnStartup(1);
    }
}

