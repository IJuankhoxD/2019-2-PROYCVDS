package edu.eci.cvds.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;


import edu.eci.cvds.persistence.mybatisimpl.MyBatisElementoDAO;
import edu.eci.cvds.services.impl.BibliotecaServicesImpl;

public class BibliotecaServicesFactory {

	private static BibliotecaServicesFactory instance = new BibliotecaServicesFactory();

    private static Optional<Injector> optInjector = Optional.empty();

    private Injector myBatisInjector(String env, String pathResource, JdbcHelper jdbcHelper) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                install(jdbcHelper);
                setClassPathResource(pathResource);
                
                bind(BibliotecaServices.class).to(BibliotecaServicesImpl.class);
                
            }
        });
    }

    private BibliotecaServicesFactory() {
    }

    public BibliotecaServices getBibliotecaServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml", JdbcHelper.MySQL));
        }

        return optInjector.get().getInstance(BibliotecaServices.class);
    }


    public BibliotecaServices getBibliotecaServicesTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml", JdbcHelper.H2_FILE));
        }

        return optInjector.get().getInstance(BibliotecaServices.class);
    }



    public static BibliotecaServicesFactory getInstance(){
        return instance;
    }

}
