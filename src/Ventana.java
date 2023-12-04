import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ventana {
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JComboBox cmbSexo;
    private JTextField txtPuntaje;
    private JList list1;
    private JButton btnEncolar;
    private JButton btnBuscarCodigo;
    private JTextField txtEdadAnimal;
    private JComboBox cmbRaza;
    private JPanel principal;
    private JButton btnBuscarRazaSexo;
    private JTextArea txtAreaCodigo;
    private JTextArea txtAreaRazaSexo;
    private JTextField txtBusquedaCodigo;
    private JComboBox cmbBusquedaRaza;
    private JComboBox cmbBusquedaSexo;
    private ColaPrioridad colap=new ColaPrioridad();
   private DefaultListModel dlm =new DefaultListModel();

    public void llenarJList() {
        dlm.removeAllElements();
        Stream<PerroKamilaSosa> ordenandoLista = colap.listarAnimales().stream().sorted();
        List<PerroKamilaSosa> ordenado = ordenandoLista.collect(Collectors.toList());
        for (PerroKamilaSosa ae : ordenado) {
            dlm.addElement(ae);
        }
        list1.setModel(dlm);
    }
    /*public void llenarJListMachos() {
        dlm.removeAllElements();
        Stream<PerroKamilaSosa> ordenandoLista = colap.listarAnimales().stream()
                .filter(ae -> ae.getSexo().equals("Macho")).sorted();
        List<PerroKamilaSosa> ordenado = ordenandoLista.collect(Collectors.toList());
        for (PerroKamilaSosa ae : ordenado) {
            dlm.addElement(ae);
        }
        list1.setModel(dlm);
    }*/

    public Ventana(){

        btnEncolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String codigo= txtCodigo.getText();
            String nombre= txtNombre.getText();
            String sexo= cmbSexo.getSelectedItem().toString();
            int edad= Integer.parseInt(txtEdadAnimal.getText());
            String raza= cmbRaza.getSelectedItem().toString();
            int puntaje= Integer.parseInt(txtPuntaje.getText());
            PerroKamilaSosa mascota=new PerroKamilaSosa(codigo,nombre,sexo,edad,raza,puntaje);
            colap.encolarAnimal(mascota);
            llenarJList();
            }
        });

        btnBuscarCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtBusquedaCodigo.getText();
                try {
                    int posicion = colap.buscarCodigo(codigo);
                    if (posicion !=0) {
                        txtAreaCodigo.setText("Animal encontrado en la posición: " + posicion + " con respecto a su raza");
                       } else {
                        txtAreaCodigo.setText("No se encontro al perro...");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
