package org.ldv.sporline.controller.admincontrollers


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminDashboardController {

    @GetMapping("/Sportline/admin/dashboard")
    fun dashboard(): String {
        return "pageAdmin/dashboard"
    }
}
