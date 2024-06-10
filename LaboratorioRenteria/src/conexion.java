import java.sql.*;



public class conexion {

    Connection con;
    Statement st;
    ResultSet rs;
    String nombre_bd = "BDConsultorioRenteria";
    String user = "root";
    String pass = "";
    String direccion = "localhost";
    int puerto = 3307;

    public conexion() {

        String url = "jdbc:mysql://" + direccion + ":" + puerto + "/" + nombre_bd;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            System.out.println("Conexion Exitosa!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void cerrarConexiones() {
        try {
            if (con.isClosed() == false) {//Si la Conexion esta Abierta
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}