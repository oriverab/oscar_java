/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import javax.servlet.http.HttpServletRequest;
import models.mascotaBean1;
import models.mascotaBeanvalidator;
import models.usuarioBean;
import models.usuarioBeanvalidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;




@Controller 
public class homeController {
    private mascotaBeanvalidator mascotavalidar; 
    private usuarioBeanvalidator usuariovalidar;
   
    
    public homeController(){
          this.mascotavalidar = new mascotaBeanvalidator();
          this.usuariovalidar = new usuarioBeanvalidator();
    }
    
    
      @RequestMapping(value="formUsuario.htm", method = RequestMethod.GET)
     public ModelAndView usuario(){
                   usuarioBean usuario= new usuarioBean();
                   ModelAndView mav = new ModelAndView();
                   mav.setViewName("views/formUsuario");
                   mav.addObject("usuario", usuario);
                   return mav;
     }
    @RequestMapping(value="formUsuario.htm", method = RequestMethod.POST) 
   public ModelAndView vistausuario( @ModelAttribute("usuario") usuarioBean user,
        BindingResult result,
        SessionStatus status
        ){
       this.usuariovalidar.validate(user, result);
       if(result.hasErrors()){
        ModelAndView mov = new ModelAndView();
        mov.addObject("usuario", new usuarioBean());
        mov.setViewName("views/formUsuario");
        return mov;
        }else{ModelAndView mav = new ModelAndView();
              mav.setViewName("views/vistaUsuario");
              mav.addObject("cedula", user.getCedula());
              mav.addObject("nombre", user.getNombres());
              mav.addObject("telefono", user.getTelefono());
              mav.addObject("email", user.getEmail());
              return mav;
                
                }
     
        
        
   }
 
    
    
   @RequestMapping(value="formMascota.htm", method = RequestMethod.GET)
     public ModelAndView mascota(){
                   mascotaBean1 mascota= new mascotaBean1();
                   ModelAndView mav = new ModelAndView();
                   mav.setViewName("views/formMascota");
                   mav.addObject("mascota", mascota);
                   return mav;
     }
    @RequestMapping(value="formMascota.htm", method = RequestMethod.POST) 
   public ModelAndView vistaMascota( @ModelAttribute("mascota") mascotaBean1 mas,
        BindingResult result,
        SessionStatus status
        ){
       this.mascotavalidar.validate(mas, result);
       if(result.hasErrors()){
        ModelAndView mov = new ModelAndView();
        mov.addObject("mascota", new mascotaBean1());
        mov.setViewName("views/formMascota");
        return mov;
        }else{ModelAndView mav = new ModelAndView();
              mav.setViewName("views/vistaMascota");
              mav.addObject("cedula", mas.getId());
              mav.addObject("nombre", mas.getNombre());
              mav.addObject("telefono", mas.getRaza());
              mav.addObject("email", mas.getTipo_animal());
              return mav;
                
                }
     
   }
   
   
}

