package com.jonghyeon.eventrestapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDTO eventDTO, Errors errors) {
        if (eventDTO.getBasePrice() > eventDTO.getMaxPrice() && eventDTO.getMaxPrice() > 0) {
            errors.reject("wrongPrices", "Values of Prices are wrong.");
        }

        LocalDateTime endEventDateTime = eventDTO.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDTO.getBeginEventDateTime()) ||
        endEventDateTime.isBefore(eventDTO.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDTO.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime", "wrong.value", "endEventTime is wrong");
        }

        // TODO beginEventDateTime
        // TODO CloseEnrollmentDateTime
    }
}
