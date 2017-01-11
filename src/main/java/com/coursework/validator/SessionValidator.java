package com.coursework.validator;

import com.coursework.model.FilmSession;
import com.coursework.services.impl.FilmSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SessionValidator implements Validator {

    @Autowired
    private FilmSessionService filmSessionService;

    @Override
    public boolean supports(Class<?> aClass) {
        return FilmSession.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FilmSession filmSession = (FilmSession) o;

        if (filmSessionService.getSessionByHallDate(filmSession.getHallId(), filmSession.getDate()) != null) {
            errors.rejectValue("Date", "Duplicate");
        }
    }
}
