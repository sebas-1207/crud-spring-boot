package com.maven.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ClienteController {

    private List<Cliente> listaClientes = new ArrayList<>();

    /* @GetMapping("/saludo/{nombre}")
    public String saludo(@PathVariable String nombre){
        return "Hola como estas, desde el pc del estudiante: " + nombre;
    }

    @GetMapping("/despedir")
    public String despedir(@RequestParam String nombre){
        return "Chao, desde el pc del estudiante: " + nombre;
    }

    @GetMapping("/apellido")
    public String nombreCompleto(@RequestParam String nombre,
                                 @RequestParam String apellido){
        return "Chao, desde el pc del estudiante: " + nombre + " " + apellido;
    }

    @GetMapping("/cliente")
    public String cliente(@RequestParam String nombre,
                          @RequestParam String apellido,
                          @RequestParam String direccion,
                          @RequestParam String telefono,
                          @RequestParam String email){
        return "Datos del cliente\n" + 
                "nombre: " + nombre + " " + apellido + "\n" +
                "direccion: " + direccion + "\n" +
                "telefono: " + telefono + "\n" +
                "email: " + email + "\n";

    }

    @PostMapping("/cliente")
    public String despedirPost(@RequestParam String nombre,
                          @RequestParam String apellido,
                          @RequestParam String direccion,
                          @RequestParam String telefono,
                          @RequestParam String email){
        return "Datos del cliente\n" + 
                "nombre: " + nombre + " " + apellido + "\n" +
                "direccion: " + direccion + "\n" +
                "telefono: " + telefono + "\n" +
                "email: " + email + "\n";

    } */
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(@RequestBody Cliente cliente){
        listaClientes.add(cliente);
        return "El cliente se creo con exito";

    }

    @GetMapping("/cliente/list")
    public List<Cliente> getListClientes(){
        return listaClientes;
    }

    @DeleteMapping("/cliente/eliminar")
    public String eliminarCliente(@RequestBody Cliente cliente){
        if(listaClientes.remove(cliente)){
            return "Se elimino con exito";
        }else{
            return "El cliente se creo con exito";
        }
    }
    
    @GetMapping("/cliente/buscar/{nombre}")
    private Cliente buscarPorNombre(@PathVariable String nombre){
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombre)) {   
                return cliente;
            }
        }
        return null;
    }
    
    @PutMapping("/cliente/actualizar/{nombre}")
    public String actualizarCliente(@PathVariable String nombre, @RequestBody Cliente clienteActualizado) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equals(nombre)) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setApellido(clienteActualizado.getApellido());
                cliente.setDireccion(clienteActualizado.getDireccion());
                cliente.setEmail(clienteActualizado.getEmail());
                cliente.setTelefono(clienteActualizado.getTelefono());
                return "Cliente actualizado correctamente";
            }
        }
        return "Cliente no encontrado";
    }
}
