package org.ldv.sporline.controller.admincontrollers

import org.ldv.sporline.dao.CategorieDAO
import org.ldv.sporline.entity.Categorie
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/Sportline/admin/categorie")
class AdminCategorieController(val categorieDAO: CategorieDAO) {

    // --- Liste des catégories ---
    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("categories", categorieDAO.findAll())
        return "pageAdmin/categorie/index"
    }

    // --- Formulaire ajout ---
    @GetMapping("/ajouter")
    fun addForm(model: Model): String {
        model.addAttribute("categorie", Categorie())
        return "pageAdmin/categorie/form"
    }

    // --- Formulaire modification ---
    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable id: Long, model: Model): String {
        val categorie = categorieDAO.findById(id).orElseThrow { Exception("Catégorie introuvable") }
        model.addAttribute("categorie", categorie)
        return "pageAdmin/categorie/form"
    }

    // --- Enregistrer ajout / modif ---
    @PostMapping("/save")
    fun save(@ModelAttribute categorie: Categorie): String {
        categorieDAO.save(categorie)
        return "redirect:/Sportline/admin/categorie"
    }

    // --- Supprimer ---
    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String {
        categorieDAO.deleteById(id)
        return "redirect:/Sportline/admin/categorie"
    }
}
