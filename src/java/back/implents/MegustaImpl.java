/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.implents;

import back.entitys.Persona;
import java.util.List;

/**
 *
 * @author juang
 */
public interface MegustaImpl {
    

    public void DarMegusta(String codSoli, String codResep);

    public void CanselarMegusta(String codSoli, String codResep);

   
    public void AseptarMegusta(String codSoli, String codResep);

    public void RechazarMegusta(String codSoli, String codResep); 
    
    public int CantidadMegusta(String cod);
    
    public List<Persona> obtenerUsuariosQueEnvianMeGusta(String cod);
    
    public List<Persona> obtenerListamegustaenviados(String cod);
    
    public List<Persona> obtenerListamegustarechazados(String cod);

}
