package org.ldv.sporline.controller.admincontrollers

import org.ldv.sporline.dao.UtilisateurDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminUtilisateurController(private val utilisateurDAO: UtilisateurDAO) {

    @GetMapping("/Sportline/admin/utilisateurs")
    fun index(model: Model): String {
        val utilisateurs = utilisateurDAO.findAll()
        model.addAttribute("utilisateurs", utilisateurs)
        return "pageAdmin/utilisateur/indexUtilisateur"
    }
}
