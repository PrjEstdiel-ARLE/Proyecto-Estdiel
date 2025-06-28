package Extras;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    //costo (work factor) recomendado 10-12 para desktop
    private static final int LOG_ROUNDS = 10;

    // Genera el hash BCrypt de la contraseña en texto plano.
    public static String hash(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(LOG_ROUNDS));
    }

    //Verifica si la contraseña ingresada coincide con el hash almacenado.
    public static boolean verificar(String plainPassword, String hashAlmacenado) {
        return BCrypt.checkpw(plainPassword, hashAlmacenado);
    }
}

