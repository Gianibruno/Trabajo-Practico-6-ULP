/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo.practico.pkg6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author giani
 */
public class Directorio {

    TreeMap<Long, Cliente> directorio = new TreeMap<>();

    public int agregarCliente(Long nrotel, Long dni, String nombre, String apellido, String ciudad, String direccion) {
        if(directorio.containsKey(nrotel)){
            return 0;
        }else{
        directorio.put(nrotel, new Cliente(dni, nombre, apellido, ciudad, direccion));
        System.out.println("Cliente: "+nombre+apellido+" DNI: "+dni+" agregado.");
        return 1;
        }
    }
    public int agregarCliente(Long nrotel,Cliente cliente) {
        if(directorio.containsKey(nrotel)){
            return 0;
        }else{
            
        directorio.put(nrotel,cliente);
        System.out.println("Cliente: "+cliente.getNombre()+" agregado.");
        return 1;
        }
    }
    public boolean existeCliente(Long tel){
        return directorio.containsKey(tel);
    }
    public Cliente buscarCliente(Long nrotel) {
        return directorio.get(nrotel);
    }

    public List<Long> buscarTelefono(String apellido) {
        List<Long> aux =new ArrayList<Long>();
        Set<Long> telefonos = directorio.keySet();
        for (Long i : telefonos) {
            if (directorio.get(i).getApellido().equalsIgnoreCase(apellido)) {
                aux.add(i);
            }
        }
        return aux;
    }
    public Long buscarTelefonoPorDni(Long dni) {
        Long aux=0L;
        Set<Long> telefonos = directorio.keySet();
        for (Long i : telefonos) {
            if (directorio.get(i).getDni()==dni) {
                aux=i;
            }
        }
        return aux;
    }

    public List<Cliente> buscarClientes(String ciudad) {
        return directorio.values().stream().filter(cliente -> cliente.getCiudad().equalsIgnoreCase(ciudad)).collect(Collectors.toList());
    }

    public Cliente borrarCliente(Long dni) {
        
        Cliente caux=directorio.remove(this.buscarTelefonoPorDni(dni));
        return caux;
    }

}
