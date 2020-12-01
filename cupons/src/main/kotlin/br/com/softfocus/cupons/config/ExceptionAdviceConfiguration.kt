package br.com.softfocus.cupons.config

import br.com.softfocus.cupons.exception.CupomNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionAdviceConfiguration {
    @ResponseBody
    @ExceptionHandler
    @ResponseStatus
    fun noResultException(e: CupomNotFoundException):String {
        return e.message;
    }

}