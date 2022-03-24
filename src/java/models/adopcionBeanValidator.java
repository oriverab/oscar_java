
package models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class adopcionBeanValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return adopcion.class.isAssignableFrom(type);  
    }

    @Override
    public void validate(Object o, Errors errors) {
        adopcion adopcion = (adopcion) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cod","requiered.cod","el campo es obligatorio id");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"fecha","requiered.fecha","el campo es obligatorio fecha");
        
    
    }
    
    
}
