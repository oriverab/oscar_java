package models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class usuarioBeanvalidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return mascotaBean1.class.isAssignableFrom(type);  
    }

    @Override
    public void validate(Object o, Errors errors) {
        usuarioBean usuario = (usuarioBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cedula","requiered.cedula","el campo es obligatorio cedula");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombres","requiered.nombres","el campo es obligatorio nombre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"telefono","requiered.telefono","el campo es obligatorio telefono");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","requiered.email","el campo es obligatorio email");
        
    
    }
    
    
}
