package az.binary.library_management_system.validations.constraint;

import az.binary.library_management_system.validations.InfoValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class InfoValidator implements ConstraintValidator<InfoValid, String> {

    @Override
    public void initialize(InfoValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String info, ConstraintValidatorContext constraintValidatorContext) {
        return info != null &&
                info.length() > 1 &&
                info.length() < 50;
    }
}