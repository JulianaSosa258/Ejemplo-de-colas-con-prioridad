import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ColaPrioridad {
    private PriorityQueue<PerroKamilaSosa> mascota;
    public ColaPrioridad(){
        mascota= new PriorityQueue<PerroKamilaSosa>();
    }
    public void encolarAnimal(PerroKamilaSosa dato) {
        boolean existe = false;
        for (PerroKamilaSosa perro : mascota) {
            if (perro.getCodigo().equals(dato.getCodigo())) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            mascota.add(dato);
            JOptionPane.showMessageDialog(null, "Animal ingresado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "El código ya existe en la lista.");
        }
    }

    public int  buscarCodigo(String codigo) throws Exception{
        String raza = "";
        int posicion = 0;
        ;
        int contador=0;
        boolean existe=false;
        if (mascota.isEmpty()) {
            throw new Exception("No se ha encontrado a la mascota");
        }
            List<PerroKamilaSosa> perro=new ArrayList<>(mascota);
            while (contador<perro.size()&&!existe){
                PerroKamilaSosa listaA=perro.get(contador);//lista que ya existe
                if(listaA.getCodigo().equals(codigo)){
                    raza=listaA.getRaza();
                    existe= true;
                }
                contador++;
            }
            if(existe){
               PriorityQueue<PerroKamilaSosa> listaRazaIgual = new PriorityQueue<>();
               for(PerroKamilaSosa p:mascota){
                   if(p.getRaza().equals(raza)){
                       listaRazaIgual.add(p);
                   }
               }
               List<PerroKamilaSosa>  filtroDatosPerro=new ArrayList<>(listaRazaIgual);
               //i
                int i = 0;
               while (i<filtroDatosPerro.size()){
                   PerroKamilaSosa listaB= filtroDatosPerro.get(i);
                   if(listaB.getCodigo().equals(codigo)){
                       posicion=i+1;
                       break;
                   }
                   i++;
               }
               return posicion;
            }  else{

                throw new Exception("No existe un animal con ese codigo en la cola");
            }



    }
  //  public int buscarRazaSexo(String sexo, String raza){



    /*public int  buscarCodigo(String codigo) throws Exception{
     int posicion=1;
     int i = -1;
     if(mascota.isEmpty()){
         throw new Exception("No se ha encontrado a la mascota");
     }
     else{
         for (PerroKamilaSosa p:mascota) {
             if (codigo.equals(p.getCodigo()) && raza.equals(p.getRaza())) {
                 return posicion;
             }
             if (raza.equals(p.getRaza())) {
                 posicion++;
             }
         }

     }

        return i;
    }*/
    public List<PerroKamilaSosa> listarAnimales(){
        return mascota.stream().collect(Collectors.toList());
    }

}
