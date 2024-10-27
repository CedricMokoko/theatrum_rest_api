package com.mokoko.utils;

public class EmailMaskingUtil {

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        
        String[] parts = email.split("@");
        String username = parts[0];
        String domain = parts[1];
        
        // Mantieni visibili solo i primi 3 caratteri del nome utente
        int visibleChars = Math.min(3, username.length());
        String visiblePart = username.substring(0, visibleChars);
        
        // Offusca il resto del nome utente con degli asterischi
        String maskedUsername = visiblePart + "*".repeat(username.length() - visibleChars);
        
        return maskedUsername + "@" + domain;
    }

}
