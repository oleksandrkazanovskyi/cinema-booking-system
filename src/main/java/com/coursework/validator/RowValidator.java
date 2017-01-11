package com.coursework.validator;

import com.coursework.model.Row;
import com.coursework.services.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RowValidator implements Validator {
    @Autowired
    private RowService rowService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Row.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Row row = (Row) o;


        if (rowService.getRowByHallIdAndRowIndex(row.getHallId(), row.getRowIndex()) != null) {
            errors.rejectValue("rowIndex", "Duplicate");
        }


    }
}
