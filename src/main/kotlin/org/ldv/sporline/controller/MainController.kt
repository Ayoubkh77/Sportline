package org.ldv.sporline.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/Sportline")
    fun home(): String = "index"

    @GetMapping("/Sportline/a-propos")
    fun aPropos(): String = "pageVisiteur/a-propos"

    @GetMapping("/Sportline/contact")
    fun contact(): String = "pageVisiteur/contact"

    @GetMapping("/Sportline/inscription")
    fun inscription(): String = "pageVisiteur/inscription"

    @GetMapping("/Sportline/produits")
    fun produits(): String = "pageVisiteur/produit"

    @GetMapping("/Sportline/rgpd")
    fun rgpd(): String = "pageVisiteur/rgpd"
}
