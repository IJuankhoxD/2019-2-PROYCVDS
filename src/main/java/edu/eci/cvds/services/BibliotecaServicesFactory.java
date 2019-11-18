package edu.eci.cvds.services;

import static com.google.inject.Guice.createInjector;
import java.util.Optional;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.services.impl.BibliotecaServicesImpl;

public class BibliotecaServicesFactory {

    private static BibliotecaServicesFactory instance = new BibliotecaServicesFactory();

    private static Injector injector;
	
    private static Injector testingInjector;

    private BibliotecaServicesFactory() {

        injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(BibliotecaServices.class).to(BibliotecaServicesImpl.class);
                
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
            }
        }
        );
        testingInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(BibliotecaServices.class).to(BibliotecaServicesImpl.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
                
            }
        }
        );     	
    }
    public BibliotecaServices getBibliotecaServices(){
        return injector.getInstance(BibliotecaServices.class);
    }
    public BibliotecaServices getBibliotecaServicesTesting(){
        return testingInjector.getInstance(BibliotecaServices.class);
    }
    public static BibliotecaServicesFactory getInstance(){
        return instance;
    }

}
