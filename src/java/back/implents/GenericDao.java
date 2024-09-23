/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.implents;

import java.util.List;

/**
 *
 * @author GRABIEL
 */
public interface GenericDao <T,V> {
     public void create(T t);
    public T find(V id);
    public List<T> findAll();
    public void update(T t);
    public void delete(V id);
    
    
}
