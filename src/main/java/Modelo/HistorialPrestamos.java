package Modelo;

public class HistorialPrestamos {

    String nombreElemento;
    String nombreUsuario;
    String cursoArea;
    String fechaInicio;
    String fechaDevolucion;
    String estadoPrestamo;
    int cantidadPrestamo;

    public int getCantidadPrestamo() {
        return cantidadPrestamo;
    }

    public void setCantidadPrestamo(int cantidadPrestamo) {
        this.cantidadPrestamo = cantidadPrestamo;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCursoArea() {
        return cursoArea;
    }

    public void setCursoArea(String cursoArea) {
        this.cursoArea = cursoArea;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    @Override
    public String toString() {
        return "HistorialPrestamos{" + "nombreElemento=" + nombreElemento + ", nombreUsuario=" + nombreUsuario + ", cursoArea=" + cursoArea + ", fechaInicio=" + fechaInicio + ", fechaDevolucion=" + fechaDevolucion + ", estadoPrestamo=" + estadoPrestamo + ", cantidadPrestamo=" + cantidadPrestamo + '}';
    }

}
