package com.avbravo.microjakartanosql;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omnifaces.cdi.Startup;

/**
 *
 * @author hantsy
 */
@Startup
@Singleton
public class Bootstrap {

    @Inject
    Logger LOG;

//    @Inject
//    TaskRepository taskRepository;

    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "bootstraping application...");

      
    }
}
