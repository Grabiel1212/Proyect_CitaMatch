/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;

/**
 *
 * @author juang
 */

public class AuthInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (session.get("user") == null) {
            // Si el usuario no está en sesión, redirigir al login
            return "login";
        }
        // Si está autenticado, continuar con la acción original
        return invocation.invoke();
    }
}