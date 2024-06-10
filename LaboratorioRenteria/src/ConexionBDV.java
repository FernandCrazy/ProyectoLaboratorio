
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ConexionBDV {

    Connection con;
    Statement st;
    ResultSet rs;

    String nombre_bd = "bdconsultoriorenteria";
    String user = "root";
    String pass = "";
    String direccion = "localhost";
    int puerto = 3306;

    private static String emailFrom = "fernando.gonzalez4119@alumnos.udg.mx";
    private static String passswordFrom = "gldgxqpqbuphgvkt";
    private static String emailTo;
    private static String subject;
    private static String content;

    private Properties mProperties;

    PreparedStatement buscarStmt;//select where pacientes
    PreparedStatement buscarCitaExamenStmt;//select where pacientes
    PreparedStatement buscarMedicosStmt;//select where medicos
    PreparedStatement buscarMedicosComboStmt;//select where medicos
    PreparedStatement buscarCitasStmt;//select where cita
    PreparedStatement borrarStmt;//delete pacientes
    PreparedStatement borrarParametrosStmt;//delete parametros
    PreparedStatement borrarMedicosStmt;//delete medicos
    PreparedStatement borrarCitaStmt;//delete cita
    PreparedStatement borrarCitaExamenStmt;//delete citaExamen
    PreparedStatement borrarResultadosParamStmt;//delete citaExamen
    PreparedStatement borrarExamenIStmt;//delete examen
    PreparedStatement borrarGrupoStmt;//delete Grupo
    PreparedStatement borrarPerfilStmt;//delete Perfil
    PreparedStatement buscarParaStmt;//select where parametros
    PreparedStatement buscarExaStmt;//select where examen
    PreparedStatement buscarDatosParamStmt;//select where examen
    PreparedStatement buscarDatosGYPStmt;//select where examen
    PreparedStatement buscarDatosGYP2Stmt;//select where examen

    public ConexionBDV() {

        String url = "jdbc:mysql://" + direccion + ":" + puerto + "/" + nombre_bd;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            System.out.println("Conexion exitosa");
            buscarCitaExamenStmt = con.prepareStatement("SELECT ce.idCitaExamen, p.NoPaciente, ce.ExamenInvidual_NoExamen, ei.Nombre AS NombreExamen, ce.tcita_NoCita, ce.tcita_NoMedico, ce.tcita_NoPaciente, p.Nombre, pe.NoPametroExa "
                    + "FROM citaexamen ce "
                    + "INNER JOIN tpacientes p ON ce.tcita_NoPaciente = p.NoPaciente "
                    + "INNER JOIN ExamenInvidual ei ON ce.ExamenInvidual_NoExamen = ei.NoExamen "
                    + "INNER JOIN parametrosexamen pe ON ei.NoExamen = pe.NoExamen "
                    + "WHERE ce.idCitaExamen = ?");

            buscarStmt = con.prepareStatement("SELECT * FROM tpacientes WHERE NoPaciente = ?");
            buscarMedicosStmt = con.prepareStatement("SELECT * FROM tmedicos WHERE clave = ?");
            buscarMedicosComboStmt = con.prepareStatement("SELECT * FROM tmedicos WHERE Cargo = ?");
            buscarCitasStmt = con.prepareStatement("SELECT * FROM tcita WHERE NoCita = ?");
            buscarDatosParamStmt = con.prepareStatement("SELECT rp.NoResultadosParametro, ci.NoCita, e.Nombre, rp.Valor_de_Analisis, rp.NoResultadosParametro, pe.Sexo AS SexoParametro, pe.Unidades, pe.ValoresReferencia, pa.Nombre AS NombreP, pa.Sexo, pa.Edad, pa.FechaNac, me.Nombre AS nombreMedico, ci.Fecha\n"
                    + "FROM parametrosexamen pe \n"
                    + "INNER JOIN exameninvidual e ON pe.NoExamen = e.NoExamen\n"
                    + "INNER JOIN resultadosparametro rp ON pe.NoPametroExa = rp.ParametrosExamen_NoPametroExa\n"
                    + "INNER JOIN tmedicos me ON me.Clave = rp.CitaExamen_tcita_NoMedico\n"
                    + "INNER JOIN tcita ci ON ci.NoCita = rp.CitaExamen_tcita_NoCita\n"
                    + "INNER JOIN tpacientes pa ON pa.NoPaciente = rp.CitaExamen_tcita_NoPaciente\n"
                    + "WHERE rp.NoResultadosParametro = ?");

            buscarDatosGYPStmt = con.prepareStatement("SELECT c.idExamenGrupo, c.ExamenInvidual_NoExamen, c.Grupo_NoGrupo, p.NoExamen, "
                    + "p.Nombre AS NombreExamenIndividual, e.Nombre AS NombreGrupo "
                    + "FROM examengrupo c "
                    + "INNER JOIN exameninvidual p ON c.ExamenInvidual_NoExamen = p.NoExamen "
                    + "INNER JOIN grupo e ON c.Grupo_NoGrupo = e.NoGrupo "
                    + "WHERE e.Nombre = ?");
            buscarDatosGYP2Stmt = con.prepareStatement("SELECT c.idExamenPerfil, c.ExamenInvidual_NoExamen, c.Perfil_NoPerfil, p.NoExamen, "
                    + "p.Nombre AS NombreExamenIndividual, e.Nombre AS NombrePerfil "
                    + "FROM examenperfil c "
                    + "INNER JOIN exameninvidual p ON c.ExamenInvidual_NoExamen = p.NoExamen "
                    + "INNER JOIN perfil e ON c.Perfil_NoPerfil = e.NoPerfil "
                    + "WHERE e.Nombre = ?");

            borrarStmt = con.prepareStatement("DELETE FROM tpacientes WHERE NoPaciente =?");
            borrarMedicosStmt = con.prepareStatement("DELETE FROM tmedicos WHERE clave =?");
            borrarCitaStmt = con.prepareStatement("DELETE FROM tcita WHERE NoCita =?");
            borrarCitaExamenStmt = con.prepareStatement("DELETE FROM citaexamen WHERE tcita_NoPaciente = ?");
            borrarResultadosParamStmt = con.prepareStatement("DELETE FROM resultadosparametro WHERE CitaExamen_tcita_NoPaciente = ?");
            borrarParametrosStmt = con.prepareStatement("DELETE FROM parametrosexamen WHERE NoPametroExa =?");
            borrarExamenIStmt = con.prepareStatement("DELETE FROM exameninvidual WHERE NoExamen =?");
            borrarGrupoStmt = con.prepareStatement("DELETE FROM grupo WHERE NoGrupo =?");
            borrarPerfilStmt = con.prepareStatement("DELETE FROM perfil WHERE NoPerfil =?");
            buscarParaStmt = con.prepareStatement("SELECT * FROM parametrosexamen WHERE NoPametroExa = ?");
            buscarExaStmt = con.prepareStatement("SELECT * FROM exameninvidual WHERE NoExamen = ?");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ejecutarConsultas(String query) {
        try {
            st.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int contarRegistros(String query) {
        int totalRegistros = 0;
        try {
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                totalRegistros = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRegistros;
    }

    public int ejecutarConsultasObtenerId(String query) {
        int auntoincrement = -1;
        try {
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                auntoincrement = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auntoincrement;
    }

    public void mostrarMedicos(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas
        String query = "SELECT * FROM TMedicos ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("Clave");
                String Cargo = rs.getString("Cargo");
                String Nombre = rs.getString("Nombre");
                String Direccion = rs.getString("Direccion");
                String TelefonoCel = rs.getString("TelefonoCel");
                String Telefono = rs.getString("Telefono");
                String Ciudad = rs.getString("Ciudad");

                Object[] fila = {Clave, Cargo, Nombre, Direccion, TelefonoCel};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarExamenesIndividuales(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas
        String query = "SELECT * FROM exameninvidual";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("NoExamen");
                String Nombre = rs.getString("Nombre");

                Object[] fila = {Clave, Nombre};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarExamenGrupo(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0); // Eliminar filas

        String query = "SELECT c.idExamenGrupo, c.ExamenInvidual_NoExamen, c.Grupo_NoGrupo, "
                + "p.Nombre AS NombreExamenIndividual, e.Nombre AS NombreGrupo "
                + "FROM examengrupo c "
                + "INNER JOIN exameninvidual p ON c.ExamenInvidual_NoExamen = p.NoExamen "
                + "INNER JOIN grupo e ON c.Grupo_NoGrupo = e.NoGrupo";

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("idExamenGrupo");
                String nombreIndividual = rs.getString("NombreExamenIndividual");
                String nombreGrupo = rs.getString("NombreGrupo");

                Object[] fila = {Clave, nombreGrupo, nombreIndividual};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarExamenPerfiles(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String query = "SELECT c.idExamenPerfil, c.ExamenInvidual_NoExamen, c.Perfil_NoPerfil, "
                + "p.Nombre AS NombreExamenIndividual, e.Nombre AS NombrePerfil "
                + "FROM examenperfil c "
                + "INNER JOIN exameninvidual p ON c.ExamenInvidual_NoExamen = p.NoExamen "
                + "INNER JOIN perfil e ON c.Perfil_NoPerfil = e.NoPerfil";

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("idExamenPerfil");
                String nombreIndividual = rs.getString("NombreExamenIndividual");
                String nombrePerfil = rs.getString("NombrePerfil");

                Object[] fila = {Clave, nombrePerfil, nombreIndividual};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarCitas(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas

        String query = "SELECT c.NoCita, c.Hora, c.Fecha, c.Estado, c.Resultados, p.Nombre, p.Telefono, p.NoPaciente "
                + "FROM TCita c "
                + "INNER JOIN TPacientes p ON c. NoPaciente = p.NoPaciente";

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int NoCita = rs.getInt("NoCita");
                String Hora = rs.getString("Hora");
                String Fecha = rs.getString("Fecha");
                String NoPaciente = rs.getString("NoPaciente");
                String Estado = rs.getString("Estado");
                String Resultados = rs.getString("Resultados");
                String Nombre = rs.getString("Nombre");
                String Telefono = rs.getString("Telefono");

                Object[] fila = {NoCita, NoPaciente, Nombre, Telefono, Hora, Fecha, Estado, Resultados};
                modeloT.addRow(fila);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarExamenesCita(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas

        String query = "SELECT ce.idCitaExamen, ce.ExamenInvidual_NoExamen, ei.Nombre AS NombreExamen, ce.tcita_NoCita, ce.tcita_NoMedico, ce.tcita_NoPaciente, p.Nombre, pe.NoPametroExa "
                + "FROM citaexamen ce "
                + "INNER JOIN tpacientes p ON ce.tcita_NoPaciente = p.NoPaciente "
                + "INNER JOIN ExamenInvidual ei ON ce.ExamenInvidual_NoExamen = ei.NoExamen "
                + "INNER JOIN parametrosexamen pe ON ei.NoExamen = pe.NoExamen "
                + "GROUP BY ce.idCitaExamen "; // Ajusta esto según la estructura de tus tablas y nombres de columnas

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int idCitaExamen = rs.getInt("idCitaExamen");
                String ExamenInvidual_NoExamen = rs.getString("NombreExamen");
                int tcita_NoCita = rs.getInt("tcita_NoCita");
                int tcita_NoMedico = rs.getInt("tcita_NoMedico");
                String Nombre = rs.getString("Nombre");
                String Parametros = rs.getString("NoPametroExa");

                Object[] fila = {idCitaExamen, Nombre, ExamenInvidual_NoExamen};
                modeloT.addRow(fila);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarRessultadosParametros(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas

        String query = "SELECT c.NoResultadosParametro, c.Valor_de_Analisis, c.ParametrosExamen_NoPametroExa, c.CitaExamen_idCitaExamen, c.CitaExamen_tcita_NoCita, p.Nombre AS NombreExamen, m.Nombre AS NombreMedico, pa.Nombre AS NombrePaciente "
                + "FROM resultadosparametro c "
                + "INNER JOIN exameninvidual p ON c.CitaExamen_ExamenInvidual_NoExamen = p.NoExamen "
                + "INNER JOIN tmedicos m ON c.CitaExamen_tcita_NoMedico = m.Clave "
                + "INNER JOIN tpacientes pa ON c.CitaExamen_tcita_NoPaciente = pa.NoPaciente";
        System.out.println("SQL:" + query);
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int NoResultadosParametro = rs.getInt("NoResultadosParametro");
                String Valor_de_Analisis = rs.getString("Valor_de_Analisis");
                int ParametrosExamen_NoPametroExa = rs.getInt("ParametrosExamen_NoPametroExa");
                int CitaExamen_idCitaExamen = rs.getInt("CitaExamen_idCitaExamen");
                int CitaExamen_tcita_NoCita = rs.getInt("CitaExamen_tcita_NoCita");
                String NombreExamen = rs.getString("NombreExamen");
                String NombreMedico = rs.getString("NombreMedico");
                String NombrePaciente = rs.getString("NombrePaciente");

                Object[] fila = {NoResultadosParametro, Valor_de_Analisis, ParametrosExamen_NoPametroExa, CitaExamen_idCitaExamen, CitaExamen_tcita_NoCita, NombreExamen, NombreMedico, NombrePaciente};

                modeloT.addRow(fila);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarDatosParaReportes(JTable tabla) {
//        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
//        modeloT.setRowCount(0); // Eliminar filas
//
//        String query = "SELECT ci.NoCita, ci.Fecha, e.Nombre, rp.CitaExamen_idCitaExamen, rp.CitaExamen_tcita_NoCita, rp.Valor_de_Analisis, rp.NoResultadosParametro, pe.Sexo AS SexoParametro, pe.Unidades, pe.ValoresReferencia, pa.Nombre AS nombrePaciente,pa.Email, me.Nombre AS nombreMedico,ci.Fecha\n"
//                + "FROM parametrosexamen pe "
//                + "INNER JOIN exameninvidual e ON pe.NoExamen = e.NoExamen "
//                + "INNER JOIN resultadosparametro rp ON pe.NoPametroExa = rp.ParametrosExamen_NoPametroExa "
//                + "INNER JOIN tmedicos me ON me.Clave = rp.CitaExamen_tcita_NoMedico "
//                + "INNER JOIN tcita ci ON ci.NoCita = rp.CitaExamen_tcita_NoCita "
//                + "INNER JOIN tpacientes pa ON pa.NoPaciente = rp.CitaExamen_tcita_NoPaciente ";

//        try {
//            Set<String> nombresPacientesProcesados = new HashSet<>(); // Conjunto para almacenar nombres de pacientes procesados
//            rs = st.executeQuery(query);
//            while (rs.next()) {
//                String nombrePaciente = rs.getString("nombrePaciente");
//                // Verificar si el nombre del paciente ya ha sido procesado
//                if (!nombresPacientesProcesados.contains(nombrePaciente)) {
//                    int Cita = rs.getInt("NoResultadosParametro");
//                    String Paciente = nombrePaciente;
//                    String Examen = rs.getString("Nombre");
//                    String Sexo = rs.getString("SexoParametro");
//                    String IdCitaExamen = rs.getString("CitaExamen_tcita_NoCita");
//                    String IdResultadosP = rs.getString("CitaExamen_tcita_NoCita");
//                    String EmailPaciente = rs.getString("Email");
//                    String Fecha = rs.getString("Fecha");
//
//                    Object[] fila = {Cita, Paciente, Examen, Sexo, IdCitaExamen, IdResultadosP, EmailPaciente, Fecha};
//                    modeloT.addRow(fila);
//
//                    // Agregar el nombre del paciente al conjunto de nombres procesados
//                    nombresPacientesProcesados.add(nombrePaciente);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//-------------------
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String query = "SELECT ci.NoCita, ci.Fecha, e.Nombre, rp.CitaExamen_idCitaExamen, rp.CitaExamen_tcita_NoCita, rp.Valor_de_Analisis, rp.NoResultadosParametro, pe.Sexo AS SexoParametro, pe.Unidades, pe.ValoresReferencia, pa.Nombre AS nombrePaciente, pa.Email, me.Nombre AS nombreMedico, ci.Fecha\n"
                + "FROM parametrosexamen pe "
                + "INNER JOIN exameninvidual e ON pe.NoExamen = e.NoExamen "
                + "INNER JOIN resultadosparametro rp ON pe.NoPametroExa = rp.ParametrosExamen_NoPametroExa "
                + "INNER JOIN tmedicos me ON me.Clave = rp.CitaExamen_tcita_NoMedico "
                + "INNER JOIN tcita ci ON ci.NoCita = rp.CitaExamen_tcita_NoCita "
                + "INNER JOIN tpacientes pa ON pa.NoPaciente = rp.CitaExamen_tcita_NoPaciente ";

        try {
            // Utilizar un mapa para almacenar los nombres de pacientes por fecha
            Map<String, Set<String>> pacientesPorFecha = new HashMap<>();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String fecha = rs.getString("Fecha");
                String nombrePaciente = rs.getString("nombrePaciente");

                // Verificar si la fecha ya tiene una entrada en el mapa
                if (!pacientesPorFecha.containsKey(fecha)) {
                    // Si no existe la fecha, crear un nuevo conjunto para esta fecha
                    pacientesPorFecha.put(fecha, new HashSet<>());
                }

                // Obtener el conjunto de pacientes para esta fecha
                Set<String> pacientesEnFecha = pacientesPorFecha.get(fecha);

                // Verificar si el paciente ya ha sido procesado para esta fecha
                if (!pacientesEnFecha.contains(nombrePaciente)) {
                    int Cita = rs.getInt("NoResultadosParametro");
                    String Paciente = nombrePaciente;
                    String Examen = rs.getString("Nombre");
                    String Sexo = rs.getString("SexoParametro");
                    String IdCitaExamen = rs.getString("CitaExamen_tcita_NoCita");
                    String IdResultadosP = rs.getString("CitaExamen_tcita_NoCita");
                    String EmailPaciente = rs.getString("Email");
                    String Fecha = rs.getString("Fecha");

                    Object[] fila = {Cita, Paciente, Examen, Sexo, IdCitaExamen, IdResultadosP, EmailPaciente, Fecha};
                    modeloT.addRow(fila);

                    // Agregar el nombre del paciente al conjunto de pacientes procesados para esta fecha
                    pacientesEnFecha.add(nombrePaciente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarDatosParaReportesBuscador(JTable tabla, JTextField textField) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String nombre = textField.getText(); // Obtener el texto del JTextField

        String query = "SELECT ci.NoCita, e.Nombre, rp.Valor_de_Analisis, rp.NoResultadosParametro, pe.Sexo AS SexoParametro, pe.Unidades, pe.ValoresReferencia, pa.Nombre AS nombrePaciente, pa.Sexo, pa.Edad, pa.FechaNac, me.Nombre AS nombreMedico, ci.Fecha\n"
                + "FROM parametrosexamen pe "
                + "INNER JOIN exameninvidual e ON pe.NoExamen = e.NoExamen "
                + "INNER JOIN resultadosparametro rp ON pe.NoPametroExa = rp.ParametrosExamen_NoPametroExa "
                + "INNER JOIN tmedicos me ON me.Clave = rp.CitaExamen_tcita_NoMedico "
                + "INNER JOIN tcita ci ON ci.NoCita = rp.CitaExamen_tcita_NoCita "
                + "INNER JOIN tpacientes pa ON pa.NoPaciente = rp.CitaExamen_tcita_NoPaciente "
                + "WHERE pa.Nombre LIKE ?"; // Agregar condición WHERE LIKE

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%"); // Establecer el parámetro del nombre con comodines para LIKE

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int Cita = rs.getInt("NoCita");
                String Paciente = rs.getString("nombrePaciente");
                String Examen = rs.getString("Nombre");
                String Sexo = rs.getString("SexoParametro");
                String NombreMedico = rs.getString("nombreMedico");

                Object[] fila = {Cita, Paciente, Examen, Sexo};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarDatosParaPacientesBuscador(JTable tabla, JTextField textField) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String nombre = textField.getText(); // Obtener el texto del JTextField

        String query = "SELECT NoPaciente, Nombre, RFC, Direccion, TelefonoCel, Telefono, Curp, Ciudad, Email FROM TPacientes "
                + "WHERE Nombre LIKE ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int NoPaciente = rs.getInt("NoPaciente");
                String Nombre = rs.getString("Nombre");
                String RFC = rs.getString("RFC");
                String Direccion = rs.getString("Direccion");
                String TelefonoCel = rs.getString("TelefonoCel");
                String Telefono = rs.getString("Telefono");
                String Curp = rs.getString("Curp");
                String Ciudad = rs.getString("Ciudad");
                String Email = rs.getString("Email");

                Object[] fila = {NoPaciente, Nombre, RFC, Direccion, TelefonoCel, Telefono, Curp, Ciudad, Email};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatosReportesBuscador(JTable tabla, JTextField textField) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String nombre = textField.getText(); // Obtener el texto del JTextField
        String query = "SELECT rp.NoResultadosParametro, pa.Nombre AS nombrePaciente, e.Nombre AS nombreExamen, pe.Sexo AS SexoParametro, rp.CitaExamen_tcita_NoCita, rp.CitaExamen_idCitaExamen "
                + "FROM parametrosexamen pe "
                + "INNER JOIN exameninvidual e ON pe.NoExamen = e.NoExamen "
                + "INNER JOIN resultadosparametro rp ON pe.NoPametroExa = rp.ParametrosExamen_NoPametroExa "
                + "INNER JOIN tmedicos me ON me.Clave = rp.CitaExamen_tcita_NoMedico "
                + "INNER JOIN tcita ci ON ci.NoCita = rp.CitaExamen_tcita_NoCita "
                + "INNER JOIN tpacientes pa ON pa.NoPaciente = rp.CitaExamen_tcita_NoPaciente "
                + "WHERE pa.Nombre LIKE ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%");

            ResultSet rs = pstmt.executeQuery();

            // Variable para controlar el nombre del paciente
            String pacienteAnterior = "";

            while (rs.next()) {
                int cita = rs.getInt("NoResultadosParametro");
                String paciente = rs.getString("nombrePaciente");
                String examen = rs.getString("nombreExamen");
                String sexo = rs.getString("SexoParametro");
                String idCitaExamen = rs.getString("CitaExamen_tcita_NoCita");
                String idResultadosP = rs.getString("CitaExamen_idCitaExamen");

                // Verificar si es la primera vez que se encuentra este paciente
                if (!paciente.equals(pacienteAnterior)) {
                    // Mostrar el paciente solo si es diferente al anterior
                    pacienteAnterior = paciente;
                } else {
                    // Si es el mismo paciente, dejar el nombre vacío
                    paciente = "";
                }

                Object[] fila = {cita, paciente, examen, sexo, idCitaExamen, idResultadosP};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
//        modeloT.setRowCount(0); // Eliminar filas
//
//        String nombre = textField.getText(); // Obtener el texto del JTextField
//        String query = "SELECT rp.NoResultadosParametro, pa.Nombre AS nombrePaciente, e.Nombre AS nombreExamen, pe.Sexo AS SexoParametro, rp.CitaExamen_tcita_NoCita, rp.CitaExamen_idCitaExamen "
//                + "FROM parametrosexamen pe "
//                + "INNER JOIN exameninvidual e ON pe.NoExamen = e.NoExamen "
//                + "INNER JOIN resultadosparametro rp ON pe.NoPametroExa = rp.ParametrosExamen_NoPametroExa "
//                + "INNER JOIN tmedicos me ON me.Clave = rp.CitaExamen_tcita_NoMedico "
//                + "INNER JOIN tcita ci ON ci.NoCita = rp.CitaExamen_tcita_NoCita "
//                + "INNER JOIN tpacientes pa ON pa.NoPaciente = rp.CitaExamen_tcita_NoPaciente "
//                + "WHERE pa.Nombre LIKE ?";
//
//        try {
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(1, "%" + nombre + "%");
//
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                int cita = rs.getInt("NoResultadosParametro");
//                String paciente = rs.getString("nombrePaciente");
//                String examen = rs.getString("nombreExamen");
//                String sexo = rs.getString("SexoParametro");
//                String idCitaExamen = rs.getString("CitaExamen_tcita_NoCita");
//                String idResultadosP = rs.getString("CitaExamen_idCitaExamen");
//
//                Object[] fila = {cita, paciente, examen, sexo, idCitaExamen, idResultadosP};
//                modeloT.addRow(fila);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void mostrarDatosParaExamenesBuscador(JTable tabla, JTextField textField) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0);

        String nombre = textField.getText();

        String query = "SELECT NoExamen, Nombre FROM exameninvidual "
                + "WHERE Nombre LIKE ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int Clave = rs.getInt("NoExamen");
                String Nombre = rs.getString("Nombre");

                Object[] fila = {Clave, Nombre};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatosParaMedicosBuscador(JTable tabla, JTextField textField) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String nombre = textField.getText(); // Obtener el texto del JTextField

        String query = "SELECT Clave, Cargo, Nombre, Direccion, TelefonoCel, Telefono, Ciudad FROM TMedicos "
                + "WHERE Nombre LIKE ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int NoMedico = rs.getInt("Clave");
                String Cargo = rs.getString("Cargo");
                String Nombre = rs.getString("Nombre");
                String Direccion = rs.getString("Direccion");
                String TelefonoCel = rs.getString("TelefonoCel");
                String Telefono = rs.getString("Telefono");
                String Ciudad = rs.getString("Ciudad");

                Object[] fila = {NoMedico, Cargo, Nombre, Direccion, TelefonoCel, Telefono, Ciudad};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatosParaCitasBuscador(JTable tabla, JTextField textField, JTextField Fecha) {
//        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
//        modeloT.setRowCount(0); // Eliminar filas
//
//        String nombre = textField.getText() ; // Obtener el texto del JTextField
//        String Fecha1 = Fecha.getText();
//                
//
//        String query = "SELECT ce.idCitaExamen, ce.ExamenInvidual_NoExamen, ei.Nombre AS NombreExamen, ce.tcita_NoCita, ce.tcita_NoMedico, ce.tcita_NoPaciente, p.Nombre AS Nombre, pe.NoPametroExa "
//                + "FROM citaexamen ce "
//                + "INNER JOIN tpacientes p ON ce.tcita_NoPaciente = p.NoPaciente "
//                + "INNER JOIN ExamenInvidual ei ON ce.ExamenInvidual_NoExamen = ei.NoExamen "
//                + "INNER JOIN parametrosexamen pe ON ei.NoExamen = pe.NoExamen " // Ajusta esto según la estructura de tus tablas y nombres de columnas
//                + "WHERE p.Nombre LIKE ? "
//                + "GROUP BY ce.idCitaExamen ";
//
//        try {
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(1, "%" + nombre + "%");
//
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                int idCitaExamen = rs.getInt("idCitaExamen");
//                String ExamenInvidual_NoExamen = rs.getString("NombreExamen");
//                int tcita_NoCita = rs.getInt("tcita_NoCita");
//                int tcita_NoMedico = rs.getInt("tcita_NoMedico");
//                String Nombre = rs.getString("Nombre");
//                String Parametros = rs.getString("NoPametroExa");
//
//                Object[] fila = {idCitaExamen, Nombre, ExamenInvidual_NoExamen};
//                modeloT.addRow(fila);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Limpiar filas de la tabla

        String nombre = textField.getText();
        String fecha = Fecha.getText();

        String query = "SELECT ce.idCitaExamen, ce.ExamenInvidual_NoExamen, ei.Nombre AS NombreExamen, ce.tcita_NoCita, ce.tcita_NoMedico, ce.tcita_NoPaciente, p.Nombre AS Nombre, pe.NoPametroExa "
                + "FROM citaexamen ce "
                + "INNER JOIN tcita tc ON ce.tcita_NoCita = tc.NoCita "
                + "INNER JOIN tpacientes p ON ce.tcita_NoPaciente = p.NoPaciente "
                + "INNER JOIN ExamenInvidual ei ON ce.ExamenInvidual_NoExamen = ei.NoExamen "
                + "INNER JOIN parametrosexamen pe ON ei.NoExamen = pe.NoExamen "
                + "WHERE p.Nombre LIKE ? AND tc.Fecha = ? " // Búsqueda exacta de la fecha como cadena en la tabla tcita
                + "GROUP BY ce.idCitaExamen ";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%");
            pstmt.setString(2, fecha);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idCitaExamen = rs.getInt("idCitaExamen");
                String NombreExamen = rs.getString("NombreExamen");
                String NombrePaciente = rs.getString("Nombre");
                String Parametros = rs.getString("NoPametroExa");

                Object[] fila = {idCitaExamen, NombrePaciente, NombreExamen};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatosParaResultadosBuscador(JTable tabla, JTextField textField, JTextField Fecha) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String nombre = textField.getText();
        String fecha = Fecha.getText();

        String query = "SELECT ce.idCitaExamen, ce.ExamenInvidual_NoExamen, ei.NoExamen ,ei.Nombre AS NombreExamen, ce.tcita_NoCita, ce.tcita_NoMedico, ce.tcita_NoPaciente, p.NoPaciente ,p.Nombre AS Nombre, pe.NoPametroExa "
                + "FROM citaexamen ce "
                + "INNER JOIN tcita tc ON ce.tcita_NoCita = tc.NoCita "
                + "INNER JOIN tpacientes p ON ce.tcita_NoPaciente = p.NoPaciente "
                + "INNER JOIN ExamenInvidual ei ON ce.ExamenInvidual_NoExamen = ei.NoExamen "
                + "INNER JOIN parametrosexamen pe ON ei.NoExamen = pe.NoExamen "
                + "WHERE p.Nombre LIKE ? AND pe.Sexo = p.Sexo AND p.Edad BETWEEN pe.EdadInicial AND pe.EdadFinal AND tc.Fecha = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%");
            pstmt.setString(2, fecha);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idCitaExamen = rs.getInt("idCitaExamen");
                String ExamenInvidual_NoExamen = rs.getString("NombreExamen");
                int tcita_NoCita = rs.getInt("tcita_NoCita");
                int NoExamen = rs.getInt("NoExamen");
                int NoPaciente = rs.getInt("NoPaciente");
                int tcita_NoMedico = rs.getInt("tcita_NoMedico");
                String Nombre = rs.getString("Nombre");
                String Parametros = rs.getString("NoPametroExa");

                Object[] fila = {Nombre, idCitaExamen, tcita_NoCita, ExamenInvidual_NoExamen, Parametros, tcita_NoMedico, NoExamen, NoPaciente};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarDatosParaParametrosBuscador(JTable tabla, JTextField textField) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String nombre = textField.getText(); // Obtener el texto del JTextField

        String query = "SELECT c.NoPametroExa, c.Unidades, c.Sexo, c.EdadInicial, c.EdadFinal, c.ValoresReferencia, p.Nombre, p.NoExamen "
                + "FROM parametrosexamen c "
                + "INNER JOIN exameninvidual p ON c.NoExamen = p.NoExamen "
                + "WHERE p.Nombre LIKE ? ";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + nombre + "%");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int Clave = rs.getInt("NoPametroExa");
                int NoExamen = rs.getInt("NoExamen");
                String Nombre = rs.getString("Nombre");
                String Descripcion = rs.getString("Sexo");
                String NomImpreso = rs.getString("EdadInicial");
                String MesaTrabajo = rs.getString("EdadFinal");
                String Unidades = rs.getString("Unidades");
                String Valores = rs.getString("ValoresReferencia");

                Object[] fila = {Clave, NoExamen, Nombre, Descripcion, NomImpreso, MesaTrabajo, Unidades, Valores};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPacientes(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas
        String query = "SELECT * FROM tpacientes ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("NoPaciente");
                String Nombre = rs.getString("Nombre");
                String RFC = rs.getString("RFC");
                String Direccion = rs.getString("Direccion");
                String TelefonoCel = rs.getString("TelefonoCel");
                String Telefono = rs.getString("Telefono");
                String Curp = rs.getString("Curp");
                String Ciudad = rs.getString("Ciudad");
                String Email = rs.getString("Email");

                Object[] fila = {Clave, Nombre, RFC, Direccion, TelefonoCel, Telefono, Curp, Ciudad, Email};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cerrarConexiones() {
        try {
            if (con.isClosed() == false) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboPacientes(JComboBox<String> CBUsuario) {
        String query = "SELECT CONCAT(NoPaciente,' - ',Nombre ) AS NoPaciente FROM tpacientes ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("NoPaciente");
                CBUsuario.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboMedicos(JComboBox<String> CBMedico) {
        String query = "SELECT CONCAT(Clave,' - ',Nombre) AS Clave FROM tmedicos";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("Clave");
                CBMedico.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboNombreP(JComboBox<String> CBNombreP) {
        String query = "SELECT CONCAT(Nombre ) AS Nombre FROM tpacientes ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("Nombre");
                CBNombreP.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboExamen(JComboBox<String> CBNombreP) {
        String query = "SELECT CONCAT(NoExamen,' - ',Nombre ) AS Nombre FROM exameninvidual ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("Nombre");
                CBNombreP.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboGYP(JComboBox<String> CBNombreP) {
        String query = "SELECT CONCAT(g.Nombre) AS Nombre FROM grupo g "
                + "UNION "
                + "SELECT CONCAT(p.Nombre) AS Nombre FROM perfil p ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("Nombre");
                CBNombreP.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboParametros(JComboBox<String> CBParametro) {
        String query = "SELECT CONCAT(g.NoPametroExa, '-', p.Nombre) AS Parametro FROM parametrosexamen g "
                + "INNER JOIN Exameninvidual p ON g.NoExamen = p.NoExamen";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String parametro = rs.getString("Parametro");
                CBParametro.addItem(parametro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboCitaConExamen(JComboBox<String> CBParametro) {
        String query = "SELECT CONCAT(g.idCitaExamen, '-', g.exameninvidual_NoExamen, '-', p.Nombre) AS id "
                + "FROM citaexamen g "
                + "INNER JOIN tpacientes p ON g.tcita_NoPaciente = p.NoPaciente";

//        String query = "SELECT CONCAT(idCitaExamen, '-', tcita_NoPaciente ) AS id FROM citaexamen";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String parametro = rs.getString("id");
                CBParametro.addItem(parametro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboNombreM(JComboBox<String> CBNombreM) {
        String query = "SELECT CONCAT(Nombre ) AS Nombre FROM tmedicos";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("Nombre");
                CBNombreM.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboCitas(JComboBox<String> CBUsuario) {
        String query = "SELECT CONCAT(g.NoCita, '-', p.Nombre) AS NoCita FROM tcita g "
                + "INNER JOIN tpacientes p ON g.NoPaciente = p.NoPaciente";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("NoCita");
                CBUsuario.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboGrupo(JComboBox<String> CBUsuario) {
        String query = "SELECT CONCAT(NoGrupo,' - ',Nombre ) AS NoGrupo FROM grupo ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("NoGrupo");
                CBUsuario.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboGrupo2(JComboBox<String> CBUsuario) {
        String query = "SELECT CONCAT(Nombre ) AS NoGrupo FROM grupo ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("NoGrupo");
                CBUsuario.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboPerfil(JComboBox<String> CBUsuario) {
        String query = "SELECT CONCAT(NoPerfil,' - ',Nombre ) AS NoPerfil FROM perfil ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("NoPerfil");
                CBUsuario.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarcomboPerfil2(JComboBox<String> CBUsuario) {
        String query = "SELECT CONCAT(Nombre ) AS NoPerfil FROM perfil ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String Clave = rs.getString("NoPerfil");
                CBUsuario.addItem(Clave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement conectar() {
        String url = "jdbc:mysql://" + direccion + ":" + puerto + "/" + nombre_bd;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

//    void generarReporte(String Sexo, String Nombre,String Fecha, String nombreArchivo) {
//
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("Sexo", Sexo);
//        parametros.put("Nombre", Nombre);
//        parametros.put("Fecha", Fecha);
//
//        try {
//            String rutaReporte = getClass().getResource("reportes/report1.jrxml").getPath().replace("%20", " ");
//            JasperReport reporte = JasperCompileManager.compileReport(rutaReporte);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con);
//
//            // Ruta de destino fija
//            String rutaDestino = "C:\\Users\\Fernando Gonzalez\\Desktop\\Trabajos escuela\\Trabajos 7tmo semestre\\Nueva carpeta\\proyectoCarrera\\LaboratorioRenteria\\src\\Analisis";
//
//            // Crear directorio si no existe
//            File directorio = new File(rutaDestino);
//            if (!directorio.exists()) {
//                directorio.mkdirs();
//            }
//
//            // Guardar reporte con el nombre ingresado
//            String nombreCompleto = rutaDestino + "/" + nombreArchivo + ".pdf";
//            JasperExportManager.exportReportToPdfFile(jasperPrint, nombreCompleto);
//
//            System.out.println("Reporte guardado exitosamente en: " + nombreCompleto);
//
////            // Mostrar reporte en visor
////            JasperViewer viewer = new JasperViewer(jasperPrint, false);
////            viewer.setTitle("Reporte Resultados");
////            viewer.setVisible(true);
////            viewer.setAlwaysOnTop(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    void generarReporte(String Sexo, String Nombre, String nombreArchivo, String Fecha) {
    Map<String, Object> parametros = new HashMap<>();
    parametros.put("Sexo", Sexo);
    parametros.put("Nombre", Nombre);
    parametros.put("Fecha", Fecha);

    try {
        String rutaReporte = getClass().getResource("reportes/report1.jrxml").getPath().replace("%20", " ");
        JasperReport reporte = JasperCompileManager.compileReport(rutaReporte);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con);

        // Ruta de destino fija
        String rutaDestino = "C:\\Users\\Fernando Gonzalez\\Desktop\\Trabajos escuela\\Trabajos 7tmo semestre\\Nueva carpeta\\proyectoCarrera\\LaboratorioRenteria\\src\\Analisis";

        // Crear directorio si no existe
        File directorio = new File(rutaDestino);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        // Guardar reporte con el nombre ingresado
        String nombreCompleto = rutaDestino + "/" + nombreArchivo + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, nombreCompleto);

        System.out.println("Reporte guardado exitosamente en: " + nombreCompleto);

//        // Mostrar reporte en visor
//        JasperViewer viewer = new JasperViewer(jasperPrint, false);
//        viewer.setTitle("Reporte Resultados");
//        viewer.setVisible(true);
//        viewer.setAlwaysOnTop(true);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    void MostrarReporte(String Sexo, String Nombre, String nombreArchivo, String Fecha) {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Sexo", Sexo);
        parametros.put("Nombre", Nombre);
        parametros.put("Fecha", Fecha);

        try {
            String rutaReporte = getClass().getResource("reportes/report1.jrxml").getPath().replace("%20", " ");
            JasperReport reporte = JasperCompileManager.compileReport(rutaReporte);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, con);

            // Mostrar reporte en visor
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setTitle("Reporte Resultados");
            viewer.setVisible(true);
            viewer.setAlwaysOnTop(true);

            System.out.println("Reporte mostrado exitosamente en el visor.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String[]> regresaDatos(String query) {
        ArrayList<String[]> datos = new ArrayList<>();
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int numColumnas = rs.getMetaData().getColumnCount();
                String fila[] = new String[numColumnas];
                for (int col = 0; col < numColumnas; col++) {
                    fila[col] = rs.getString(col + 1);
                }
                datos.add(fila);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return datos;
    }

    void buscarPacientes(JTable TablaPacientes, JTextField TFClave, JTextField TFNombre,JComboBox CBSexo, JTextField TFEdad, JTextField TFNacimiento, JTextField TFRFC, JTextField TFDireccion, JTextField TFTelefonoCel, JTextField TFTelefono, JTextField TFCurp, JTextField TFCiudad, JTextField TFEmail) {

        DefaultTableModel modelo = (DefaultTableModel) TablaPacientes.getModel();
        int renglonSeleccionado = TablaPacientes.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 0).toString();
                buscarStmt.setString(1, Clave);
                rs = buscarStmt.executeQuery();
                if (rs.next()) {

                    TFClave.setText(rs.getString("NoPaciente"));
                    TFNombre.setText(rs.getString("Nombre"));
                    CBSexo.setSelectedItem(rs.getString("Sexo"));
                    TFEdad.setText(rs.getString("Edad"));
                    TFNacimiento.setText(rs.getString("FechaNac"));
                    TFRFC.setText(rs.getString("RFC"));
                    TFDireccion.setText(rs.getString("Direccion"));
                    TFTelefonoCel.setText(rs.getString("TelefonoCel"));
                    TFTelefono.setText(rs.getString("Telefono"));
                    TFCurp.setText(rs.getString("Curp"));
                    TFCiudad.setText(rs.getString("Ciudad"));
                    TFEmail.setText(rs.getString("Email"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void buscarCitaExamen(JTable TablaPacientes, JTextField TFClave, JTextField TFNombre, JTextField TFRFC, JTextField TFExmen, JTextField TFParametro) {

        DefaultTableModel modelo = (DefaultTableModel) TablaPacientes.getModel();
        int renglonSeleccionado = TablaPacientes.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 1).toString();
                buscarCitaExamenStmt.setString(1, Clave);
                rs = buscarCitaExamenStmt.executeQuery();
                if (rs.next()) {

                    TFClave.setText(rs.getString("idCitaExamen"));
                    TFRFC.setText(rs.getString("tcita_NoCita"));
                    TFNombre.setText(rs.getString("NoPaciente"));
                    TFExmen.setText(rs.getString("ExamenInvidual_NoExamen"));
                    TFParametro.setText(rs.getString("NoPametroExa"));
//                    TFMedico.setText(rs.getString("tcita_NoMedico"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void borrarPacientes(String codigo) {
        try {
            borrarStmt.setString(1, codigo);
            borrarStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarParametros(String codigo) {
        try {
            borrarParametrosStmt.setString(1, codigo);
            borrarParametrosStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarMedicos(String codigo) {
        try {
            borrarMedicosStmt.setString(1, codigo);
            borrarMedicosStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarCitas(String codigo) {
        try {
            borrarCitaStmt.setString(1, codigo);
            borrarCitaStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarCitaExamen(String codigo) {
        try {
            borrarCitaExamenStmt.setString(1, codigo);
            borrarCitaExamenStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarResultadosParam(String codigo) {
        try {
            borrarResultadosParamStmt.setString(1, codigo);
            borrarResultadosParamStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarExamenIndividual(String codigo) {
        try {
            borrarExamenIStmt.setString(1, codigo);
            borrarExamenIStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarGrupo(String codigo) {
        try {
            borrarGrupoStmt.setString(1, codigo);
            borrarGrupoStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void borrarPerfil(String codigo) {
        try {
            borrarPerfilStmt.setString(1, codigo);
            borrarPerfilStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarParametros(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas
        String query = "SELECT c.NoPametroExa, c.Unidades, c.Sexo, c.EdadInicial, c.EdadFinal, c.ValoresReferencia, p.Nombre, p.NoExamen "
                + "FROM parametrosexamen c "
                + "INNER JOIN exameninvidual p ON c.NoExamen = p.NoExamen";

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("NoPametroExa");
                int NoExamen = rs.getInt("NoExamen");
                String Nombre = rs.getString("Nombre");
                String Descripcion = rs.getString("Sexo");
                String NomImpreso = rs.getString("EdadInicial");
                String MesaTrabajo = rs.getString("EdadFinal");
                String Unidades = rs.getString("Unidades");
                String Valores = rs.getString("ValoresReferencia");

                Object[] fila = {Clave, NoExamen, Nombre, Descripcion, NomImpreso, MesaTrabajo, Unidades, Valores};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarCitaExamen(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
        modeloT.setRowCount(0); // Eliminar filas

        String query = "SELECT ce.idCitaExamen, ce.ExamenInvidual_NoExamen, ei.Nombre AS NombreExamen, "
                + "ce.tcita_NoCita, ce.tcita_NoMedico, ce.tcita_NoPaciente, p.Nombre, pe.NoPametroExa "
                + "FROM citaexamen ce "
                + "INNER JOIN tpacientes p ON ce.tcita_NoPaciente = p.NoPaciente "
                + "INNER JOIN ExamenInvidual ei ON ce.ExamenInvidual_NoExamen = ei.NoExamen "
                + "INNER JOIN parametrosexamen pe ON ei.NoExamen = pe.NoExamen"; // Ajusta esto según la estructura de tus tablas y nombres de columnas

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int idCitaExamen = rs.getInt("idCitaExamen");
                String ExamenInvidual_NoExamen = rs.getString("NombreExamen");
                int tcita_NoCita = rs.getInt("tcita_NoCita");
                int tcita_NoMedico = rs.getInt("tcita_NoMedico");
                String Nombre = rs.getString("Nombre");
                String Parametros = rs.getString("NoPametroExa");

                Object[] fila = {Nombre, idCitaExamen, tcita_NoCita, ExamenInvidual_NoExamen, Parametros, tcita_NoMedico};
                modeloT.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void buscarExamenes(JTable TAnalisis, JTextField TFClave, JTextField TFClave2) {

        DefaultTableModel modelo = (DefaultTableModel) TAnalisis.getModel();
        int renglonSeleccionado = TAnalisis.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 0).toString();
                buscarExaStmt.setString(1, Clave);
                rs = buscarExaStmt.executeQuery();
                if (rs.next()) {

                    TFClave.setText(rs.getString("NoExamen"));
                    TFClave2.setText(rs.getString("NoExamen"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void buscarExamenes2(JTable TAnalisis, JTextField TFClave) {

        DefaultTableModel modelo = (DefaultTableModel) TAnalisis.getModel();
        int renglonSeleccionado = TAnalisis.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 0).toString();
                buscarExaStmt.setString(1, Clave);
                rs = buscarExaStmt.executeQuery();
                if (rs.next()) {

                    TFClave.setText(rs.getString("NoExamen"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void buscarDatosReportes(JTable TAnalisis, JTextField TFNombre, JTextField TFSexo) {

        DefaultTableModel modelo = (DefaultTableModel) TAnalisis.getModel();
        int renglonSeleccionado = TAnalisis.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 0).toString();
                buscarDatosParamStmt.setString(1, Clave);
                rs = buscarDatosParamStmt.executeQuery();
                if (rs.next()) {

                    TFNombre.setText(rs.getString("NombreP"));
                    TFSexo.setText(rs.getString("Sexo"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    void buscarParametros(JTable TParametros, JTextField TFClave) {

        DefaultTableModel modelo = (DefaultTableModel) TParametros.getModel();
        int renglonSeleccionado = TParametros.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 0).toString();
                buscarParaStmt.setString(1, Clave);
                rs = buscarParaStmt.executeQuery();
                if (rs.next()) {

                    TFClave.setText(rs.getString("NoPametroExa"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void buscarMedicos(JTable TablaMedicos, JTextField TFClave, JTextField TFNombre, JComboBox CBCargo, JTextField TFDireccion, JTextField TFTelefonoCel, JTextField TFTelefono, JTextField TFCiudad) {

        DefaultTableModel modelo = (DefaultTableModel) TablaMedicos.getModel();
        int renglonSeleccionado = TablaMedicos.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 0).toString();
                buscarMedicosStmt.setString(1, Clave);
                rs = buscarMedicosStmt.executeQuery();
                if (rs.next()) {
                    TFClave.setText(rs.getString("Clave"));
                    TFNombre.setText(rs.getString("Nombre"));
                    CBCargo.setSelectedItem(rs.getString("Cargo"));
                    TFDireccion.setText(rs.getString("Direccion"));
                    TFTelefonoCel.setText(rs.getString("TelefonoCel"));
                    TFTelefono.setText(rs.getString("Telefono"));
                    TFCiudad.setText(rs.getString("Ciudad"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void buscarCita(JTable TablaMedicos, JTextField TFClave) {

        DefaultTableModel modelo = (DefaultTableModel) TablaMedicos.getModel();
        int renglonSeleccionado = TablaMedicos.getSelectedRow();
        String Clave;
        if (renglonSeleccionado != -1) {
            try {
                Clave = modelo.getValueAt(renglonSeleccionado, 0).toString();
                buscarCitasStmt.setString(1, Clave);
                rs = buscarCitasStmt.executeQuery();
                if (rs.next()) {
                    TFClave.setText(rs.getString("NoCita"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mostrarCita1(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas

        String query = "SELECT c.NoCita, c.Hora, c.Fecha, c.Estado, c.Resultados, p.Nombre, p.Telefono "
                + "FROM TCita c "
                + "INNER JOIN TPacientes p ON c. NoPaciente = p.NoPaciente";

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int NoCita = rs.getInt("NoCita");
                String Hora = rs.getString("Hora");
                String Fecha = rs.getString("Fecha");
                String Estado = rs.getString("Estado");
                String Resultados = rs.getString("Resultados");
                String Nombre = rs.getString("Nombre");
                String Telefono = rs.getString("Telefono");

                Object[] fila = {NoCita, Nombre, Telefono, Hora, Fecha, Estado, Resultados};
                modeloT.addRow(fila);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarGrupos(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas
        String query = "SELECT * FROM grupo ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("NoGrupo");
                String Nombre = rs.getString("Nombre");

                Object[] fila = {Clave, Nombre};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarPerfil(JTable tabla) {
        DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();

        modeloT.setRowCount(0);//Eliminar filas
        String query = "SELECT * FROM perfil ";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                int Clave = rs.getInt("NoPerfil");
                String Nombre = rs.getString("Nombre");

                Object[] fila = {Clave, Nombre};
                modeloT.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cargarExamenesGrupo(JTable TDatos, String CBGYP) {

        DefaultTableModel modeloT = (DefaultTableModel) TDatos.getModel();
        HashSet<String> nombresExistentes = new HashSet<>();

// Llenar el conjunto con los nombres de examen ya presentes en la tabla
        for (int i = 0; i < modeloT.getRowCount(); i++) {
            String nombreExamen = (String) modeloT.getValueAt(i, 1); // El nombre del examen está en la segunda columna (índice 1)
            nombresExistentes.add(nombreExamen);
        }

        try {
            buscarDatosGYPStmt.setString(1, CBGYP);
            ResultSet rs = buscarDatosGYPStmt.executeQuery();

            while (rs.next()) {
                int idExamenGrupo = rs.getInt("NoExamen");
                String nombreExamenIndividual = rs.getString("NombreExamenIndividual");

                // Verificar si el nombre de examen ya existe en la tabla
                if (!nombresExistentes.contains(nombreExamenIndividual)) {
                    // Agregar el nombre de examen a la tabla y al conjunto de nombres existentes
                    Object[] fila = {idExamenGrupo, nombreExamenIndividual};
                    modeloT.addRow(fila);
                    nombresExistentes.add(nombreExamenIndividual);
                }
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cargarExamenesPerfil(JTable TDatos, String CBGYP) {

        DefaultTableModel modeloT = (DefaultTableModel) TDatos.getModel();
        HashSet<String> nombresExistentes = new HashSet<>();

// Llenar el conjunto con los nombres de examen ya presentes en la tabla
        for (int i = 0; i < modeloT.getRowCount(); i++) {
            String nombreExamen = (String) modeloT.getValueAt(i, 1); // El nombre del examen está en la segunda columna (índice 1)
            nombresExistentes.add(nombreExamen);
        }

        try {
            buscarDatosGYP2Stmt.setString(1, CBGYP);
            ResultSet rs = buscarDatosGYP2Stmt.executeQuery();

            while (rs.next()) {
                int idExamenGrupo = rs.getInt("NoExamen");
                String nombreExamenIndividual = rs.getString("NombreExamenIndividual");

                // Verificar si el nombre de examen ya existe en la tabla
                if (!nombresExistentes.contains(nombreExamenIndividual)) {
                    // Agregar el nombre de examen a la tabla y al conjunto de nombres existentes
                    Object[] fila = {idExamenGrupo, nombreExamenIndividual};
                    modeloT.addRow(fila);
                    nombresExistentes.add(nombreExamenIndividual);
                }
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cargarMedicosCombo(JTable TDatos, String CBGYP) {

        DefaultTableModel modeloT = (DefaultTableModel) TDatos.getModel();
        modeloT.setRowCount(0);

        try {
            buscarMedicosComboStmt.setString(1, CBGYP);
            ResultSet rs = buscarMedicosComboStmt.executeQuery();

            while (rs.next()) {
                int Clave = rs.getInt("Clave");
                String Cargo = rs.getString("Cargo");
                String Nombre = rs.getString("Nombre");
                String Direccion = rs.getString("Direccion");
                String TelefonoCel = rs.getString("TelefonoCel");
                String Telefono = rs.getString("Telefono");
                String Ciudad = rs.getString("Ciudad");

                Object[] fila = {Clave, Cargo, Nombre, Direccion, TelefonoCel};
                modeloT.addRow(fila);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
