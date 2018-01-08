package basesdatospostgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kernel-2018
 */
public class BasesDatosPostgresql {

    //Implementacion de conexion de la base de datos a postgresql
    Connection conn = null;
    //Implementacion de conexion de la base de datos a postgresql

    //generar consultasa a la base de datos a postgresql
    Statement st = null; //objetos interfaces
    ResultSet rs = null;//objetos interfaces

    public BasesDatosPostgresql() {
        try {

            //111111111////////////////////////////////////////////////////////////////////////////////////////////////////
            //Implementacion de conexion de la base de datos a postgresql
            Class.forName("org.postgresql.Driver");
            //Implementacion de conexion de la base de datos a postgresql
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos", "postgres", "root");

            //generar consultasa a la base de datos a postgresql
            st = conn.createStatement();
            rs = st.executeQuery("Select * from clientes");// comando de sql para la base de datos
            //generar consultasa a la base de datos a postgresql

            while (rs.next()) {
                int id = rs.getInt(1);//numero uno (1) hace parte de la columna de la tabla que estamos recorriendo y asi sucesivamente hacer completar todas las consultas
                String cedula = rs.getString(2);
                String nombrecita = rs.getString(3);
                String nombreContacto = rs.getString(4);
                String direccionCli = rs.getString(5);

                System.out.println("id : " + id);
                System.out.println("Cedula : " + cedula);
                System.out.println("nombrecita :" + nombrecita);
                System.out.println("nombre Contacto :" + nombreContacto);
                System.out.println("direccionCli :" + direccionCli);

            }
            //111111111//////////////////////////////////////////////////////////////////////////////////////////////////
            //2222222////////////////////////////////////////////////////////////////////////////////////////////////////
            //ingresar-insertar un dato datos desde java a nuestra tabla de la base de datos
            st.executeUpdate("insert into clientes(clienteid,cedula_rut,nombrecita,nombrecontacto,direccioncli)"
                    + "values (11,'1122334555','MI NEGOCIO','VERONICA VELEZ','DOMICILIO CONOCIDO')");
            //INGRESA ESTOS VALORES A LA BASE DE DATOS PERO EL EL RESTO HAY QUE COMENTARLO
            //2222222////////////////////////////////////////////////////////////////////////////////////////////////////

            //3333333//////////////////////////////////////////////////////////////////////////////////////////////////
            //ACTUALIZACION DE UN VALOR EN LA BASE DE DATOS
            st.executeUpdate("UPDATE clientes SET nombrecia='YATE' WHERE clienteid=11");
            //3333333////////////////////////////////////////////////////////////////////////////////////////////////

            //4444444444//////////////////////////////////////////////////////////////////////////////////////////////
            //BORRAR UN REGISTRO DE LA BASE DE DATOS
            st.executeUpdate("DELETE FROM clientes WHERE clienteid=11");
            //4444444444//////////////////////////////////////////////////////////////////////////////////////////////

        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(BasesDatosPostgresql.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        } catch (SQLException ex) {
            // Logger.getLogger(BasesDatosPostgresql.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        BasesDatosPostgresql camilo = new BasesDatosPostgresql();

    }

}
