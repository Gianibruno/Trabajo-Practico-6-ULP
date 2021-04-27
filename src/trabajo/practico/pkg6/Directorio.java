/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo.practico.pkg6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author giani
 */
public class Directorio {

    TreeMap<Long, Cliente> directorio = new TreeMap<>();

    public void agregarCliente(Long nrotel, Long dni, String nombre, String apellido, String ciudad, String direccion) {
        directorio.put(nrotel, new Cliente(dni, nombre, apellido, ciudad, direccion));
    }

    public Cliente buscarCliente(Long nrotel) {

        return directorio.get(nrotel);
    }

    public List<Long> buscarTelefono(String apellido) {
        List<Long> aux = null;
        Set<Long> telefonos = directorio.keySet();
        for (Long i : telefonos) {
            if (directorio.get(i).getApellido() == apellido) {
                aux.add(i);
            }
        }
        return aux;
    }

    public List<Cliente> buscarClientes(String ciudad) {

        return;
    }

    public void borrarCliente(Long dni) {
        directorio.forEach((k, v) -> {
            if (v.getDni() == dni) {
                directorio.remove(k);
            }
        });

    }

}
