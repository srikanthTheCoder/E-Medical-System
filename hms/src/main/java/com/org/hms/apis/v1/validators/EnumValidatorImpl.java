package com.org.hms.apis.v1.validators;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

    private List<String> valuesInEnum;
    private boolean required;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (Optional.ofNullable(value).isPresent())
        {
            return required ? valuesInEnum.contains(value) : (value.isEmpty() || valuesInEnum.contains(value));
        }

        return false;
    }

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        this.required = constraintAnnotation.required();
        valuesInEnum = Stream.of(constraintAnnotation.enumType().getEnumConstants()).map(Enum::name)
                .collect(Collectors.toList());
    }
}
