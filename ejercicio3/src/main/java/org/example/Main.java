package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run( Main.class, args );

        UsuarioRepository repository = context.getBean( UsuarioRepository.class );
        System.out.println( "\n---> Registros encontrados: " + repository.count() + "\n" );

        // - - -

        Usuario usuario1 = new Usuario();
        usuario1.setNombre( "Juan" );

        repository.save( usuario1 );
        System.out.println( "\n---> Registros encontrados: " + repository.count() + "\n" );

        // - - -

        List<Usuario> usuarios = repository.findAll();
        for( Usuario u : usuarios )
        {
            System.out.println( "\n---> ID: " + u.getId() + ", Usuario: " + u.getNombre() + "\n" );
        }
    }
}
