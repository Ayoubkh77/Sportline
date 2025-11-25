package org.ldv.sporline.controller.admincontrollers

import org.ldv.sporline.dao.ProduitDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminProduitController(private val produitDAO: ProduitDAO) {

    @GetMapping("/Sportline/admin/produits")
    fun index(model: Model): String {
        val produits = produitDAO.findAll()
        model.addAttribute("produits", produits)
        return "pageAdmin/produit/indexProduit"
    }
}
