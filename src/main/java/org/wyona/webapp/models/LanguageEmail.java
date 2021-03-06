package org.wyona.webapp.models;

import org.wyona.webapp.interfaces.EmailValidation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class LanguageEmail implements Serializable {

    public enum Language {

        ENGLISH("en", "Hello World"),
        GERMAN("de", "Hallo Welt"),
        BOSNIAN("ba", "Pozdrav svijetu");

        private final String languageCode;
        private final String message;

        Language(String languageCode, String message) {
            this.languageCode = languageCode;
            this.message = message;
        }

        public static Language getLanguageByCode(String languageCode) {
            for (Language l: values()) {
                if (l.languageCode.equals(languageCode))
                    return l;
            }

            // avoid returning null and then checking in caller whether the returned value is null. Try to localize the logic.
            throw new IllegalArgumentException("Language '" + languageCode + "' not supported yet!");
        }

        public String getMessage() {
            return this.message;
        }
    }

    @NotBlank(message = "Email cannot be empty or null")
    @Email(regexp = EmailValidation.EMAIL_VALIDATION_REGEX, message = "Submitted email is not valid")
    private String email;

    @NotBlank(message = "Language code cannot be empty or null")
    private String languageCode;

    public String getEmail() {
        return email;
    }

    public String getLanguageCode() {
        return languageCode;
    }

}
