package org.ldv.sporline.controller

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

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

    // ---------- LOGIN ----------
    @GetMapping("/Sportline/login")
    fun login(@RequestParam(required = false) error: Boolean?, model: Model): String {
        model.addAttribute("error", error == true)
        return "pageVisiteur/login"
    }

    // ---------- PROFIL ----------
    @GetMapping("/Sportline/profile")
    fun profile(authentication: Authentication): String {
        // Récupération des rôles de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection vers le dashboard
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/Sportline/admin/dashboard"
        }

        // Sinon → affichage de la page profil pour le client
        return "pageClient/profile"
    }
}
