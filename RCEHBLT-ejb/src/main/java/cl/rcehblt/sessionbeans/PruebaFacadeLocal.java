/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Prueba;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface PruebaFacadeLocal {

    void create(Prueba prueba);

    void edit(Prueba prueba);

    void remove(Prueba prueba);

    Prueba find(Object id);

    List<Prueba> findAll();

    List<Prueba> findRange(int[] range);

    int count();
    
}
