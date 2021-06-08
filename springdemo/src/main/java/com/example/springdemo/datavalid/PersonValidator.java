package com.example.springdemo.datavalid;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.*;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "age too small");
        } else if (p.getAge() > 110) {
            errors.rejectValue("age", "too.darn.old");
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("adf");
        person.setAge(-100);
        DataBinder binder = new DataBinder(person);
        binder.setValidator(new PersonValidator());
        // validate the target object
        binder.validate();
        // get BindingResult that includes any validation errors
        BindingResult results = binder.getBindingResult();
        results.getFieldErrors().forEach(objectError -> {
            System.out.println(objectError.getCode());
        });

        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(person);

    }
}
