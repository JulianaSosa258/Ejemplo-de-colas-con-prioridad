import java.util.PriorityQueue;

public class PerroKamilaSosa implements Comparable<PerroKamilaSosa>{
   private String codigo;
   private String nombre;
   private String sexo;
   private int edad;
   private String raza;
   private int puntaje;

   public PerroKamilaSosa(String codigo, String nombre, String sexo, int edad, String raza, int puntaje) {
      this.codigo = codigo;
      this.nombre = nombre;
      this.sexo = sexo;
      this.edad = edad;
      this.raza = raza;
      this.puntaje=puntaje;

   }

   public String getCodigo() {
      return codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getSexo() {
      return sexo;
   }

   public void setSexo(String sexo) {
      this.sexo = sexo;
   }

   public int getEdad() {
      return edad;
   }

   public void setEdad(int edad) {
      this.edad = edad;
   }

   public String getRaza() {
      return raza;
   }

   public void setRaza(String raza) {
      this.raza = raza;
   }

   public int getPuntaje() {
      return puntaje;
   }

   public void setPuntaje(int puntaje) {
      this.puntaje = puntaje;
   }

   @Override
   public int compareTo(PerroKamilaSosa o) {
      if(this.puntaje<o.getPuntaje()){
         return  1;

      }
      return -1;
   }

   @Override
   public String toString() {
      return "Codigo: " + codigo +
              ", Nombre: " + nombre +
              ", Sexo: " + sexo +
              ", Edad: " + edad +
              ", Raza: " + raza +
              ", Puntaje: " + puntaje;
   }
}
