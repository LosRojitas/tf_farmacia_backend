package com.example.botica.Repository; // Definimos el paquete donde se encuentra la clase Repository.

import com.example.botica.Model.Producto; //Importamos la clase Producto que es nuestra entidad en la DB.
import org.springframework.data.jpa.repository.JpaRepository; //Importamos JpaRepository, que es una interfaz de Spring
// Data JPA que nos proporciona todos los métodos CRUD
//listos para usar.

public interface ProductoRepository extends JpaRepository<Producto,Long> //Definimos la interfaz ProductoRepository que
        // extiende JpaRepository. Esto le permite interactuar con la base de datos
        //utilizando los métodos proporcionados por JpaRepository.
{

}
