
package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {
    
    public static String encryptPassword(String password) {
        try {
            // Obtener instancia del algoritmo de hash (SHA-256 en este caso)
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Aplicar hash a la contraseña
            byte[] hashedPassword = md.digest(password.getBytes());
            
            // Convertir bytes a representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
