package ru.yarilin.springcourse.FirstSecurityApp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.yarilin.springcourse.FirstSecurityApp.models.Person;
import ru.yarilin.springcourse.FirstSecurityApp.services.PersonDetailsService;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (personDetailsService.findUserByUsername(person.getUsername()).isPresent()){
            errors.rejectValue("username", "", "Человек с таким именем уже существует");
        }
    }
}
