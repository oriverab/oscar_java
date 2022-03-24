
package models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class mascotaBeanvalidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return mascotaBean1.class.isAssignableFrom(type);  
    }

    @Override
    public void validate(Object o, Errors errors) {
        mascotaBean1 mascota = (mascotaBean1) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","requiered.nombre","el campo es obligatorio nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"raza","requiered.raza","el campo es obligatorio telefono");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"tipo_animal","requiered.animal","el campo es obligatorio email");
        
    
    }
    
    
}
