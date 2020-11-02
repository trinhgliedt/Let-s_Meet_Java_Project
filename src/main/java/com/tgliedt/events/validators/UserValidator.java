package com.tgliedt.events.validators;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tgliedt.events.models.User;
import com.tgliedt.events.services.UserService;

@Component
public class UserValidator implements Validator {
	
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
	@Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }  
        }
        
	
	public void validateEmail(Object target, Errors errors, UserService userService) {
		User user = (User) target;
		User foundUser = userService.findByEmail(user.getEmail());
		if (foundUser != null) {
			errors.rejectValue("email", "Found");
		}
	}
	
}
