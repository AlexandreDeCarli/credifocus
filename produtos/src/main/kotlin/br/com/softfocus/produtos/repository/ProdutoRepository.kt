package br.com.softfocus.produtos.repository

import br.com.softfocus.produtos.model.Produto
import org.springframework.data.jpa.repository.JpaRepository


open interface ProdutoRepository : JpaRepository<Produto, Long>