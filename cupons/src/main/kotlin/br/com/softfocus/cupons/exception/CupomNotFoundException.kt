package br.com.softfocus.cupons.exception

import java.lang.Exception
import java.lang.RuntimeException

class CupomNotFoundException(override var message: String): RuntimeException() {

}