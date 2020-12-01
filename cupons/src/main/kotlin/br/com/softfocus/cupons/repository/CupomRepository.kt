package br.com.softfocus.cupons.repository

import br.com.softfocus.cupons.model.Cupom
import org.springframework.data.repository.CrudRepository

interface CupomRepository : CrudRepository<Cupom, String> {
}