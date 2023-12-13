/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "WSOperaciones")
public class WSOperaciones {
    
    public static int us=2;
    public static Newclient[] client = new Newclient[20];
    

    public class Newclient {
        String NCuenta;
        String usuario;
        double saldo;
        String contrasena;
    }
   
    @WebMethod(operationName = "Cargardatos")
    public void Cargardatos() {
        client[1] = new Newclient();
        client[1].NCuenta = "101822";
        client[1].usuario = "michelle";
        client[1].saldo = 100;
        client[1].contrasena = "mich1234";
    }

    @WebMethod(operationName = "login")
    public boolean LoguinAcceso(String usuario, String password) {
        boolean cond = false;
        for (int i = 1; i < us; i++) {
            if (usuario.equals(client[i].usuario) && password.equals(client[i].contrasena)) {
                cond = true;
                break;
            }
        }
        return cond;
    }

    @WebMethod(operationName = "Registrar")
    public void Registrar(String usuario, String pass, double saldo, String Ncuenta) {
        client[us] = new Newclient();
        client[us].NCuenta = Ncuenta;
        client[us].usuario = usuario;
        client[us].saldo = saldo;
        client[us].contrasena = pass;
        us++;
    }

    @WebMethod(operationName = "Depositar")
    public void Depositar(String cuenta, double valor) {
        for (int i = 1; i < us; i++) {
            if (cuenta.equals(client[i].usuario)) {
                client[i].saldo = client[i].saldo + valor;
            }
        }
    }

    @WebMethod(operationName = "Retirar")
    public void Retirar(String cuenta, double valor) {
        for (int i = 1; i < us; i++) {
            if (cuenta.equals(client[i].usuario)) {
                client[i].saldo = client[i].saldo - valor;
            }
        }
    }

}
