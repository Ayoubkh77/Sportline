package org.ldv.sporline.service

import org.ldv.sporline.dao.*
import org.ldv.sporline.entity.*
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class     DataInitializer(
    private val categorieDAO: CategorieDAO,
    private val produitDAO: ProduitDAO,
    private val couleurDAO: CouleurDAO,
    private val tailleDAO: TailleDAO,
    private val variationDAO: VariationDAO,
    private val imageDAO: ImageDAO,
    private val utilisateurDAO: UtilisateurDAO,
    private val roleDAO: RoleDAO,
    private val panierDAO: PanierDAO,
    private val lignePanierDAO: LignePanierDAO,
    private val commandeDAO: CommandeDAO,
    private val paiementDAO: PaiementDAO,
    private val avisDAO: AvisDAO,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        if (categorieDAO.count() > 0L || utilisateurDAO.count() > 0L) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données boutique sport...")

        // ---------- RÔLES ----------
        val adminRole = Role(nom = "ADMIN", description = "Administrateur")
        val userRole = Role(nom = "USER", description = "Utilisateur")
        roleDAO.saveAll(listOf(adminRole, userRole))

        // ---------- UTILISATEURS ----------
        val admin = Utilisateur(
            nom = "Martin",
            prenom = "Sophie",
            email = "admin@sportline.com",
            motDePasse = passwordEncoder.encode("admin123"),
            telephone = "0611111111"
        ).apply { role = adminRole }

        val client = Utilisateur(
            nom = "Dupont",
            prenom = "Paul",
            email = "paul@sportline.com",
            motDePasse = passwordEncoder.encode("client123"),
            telephone = "0600000000"
        ).apply { role = userRole }

        utilisateurDAO.saveAll(listOf(admin, client))

        // ---------- CATÉGORIES ----------
        val catFitness = Categorie(nom = "Équipement Fitness", description = "Tapis, haltères, accessoires")
        val catVetements = Categorie(nom = "Vêtements Sportifs", description = "T-shirts, shorts, survêtements")
        val catChaussures = Categorie(nom = "Chaussures", description = "Running, basket, multisports")
        val catCollectifs = Categorie(nom = "Sports Collectifs", description = "Football, basket, handball")
        val catOutdoor = Categorie(nom = "Sports de Plein Air", description = "Vélo, randonnée, camping")
        val catNatation = Categorie(nom = "Natation & Plage", description = "Maillots, lunettes, palmes")
        val catAccessoires = Categorie(nom = "Accessoires", description = "Sacs, gourdes, montres connectées")

        categorieDAO.saveAll(listOf(catFitness, catVetements, catChaussures, catCollectifs, catOutdoor, catNatation, catAccessoires))

        // ---------- COULEURS ----------
        val rouge = Couleur(nom = "Rouge")
        val bleu = Couleur(nom = "Bleu")
        val noir = Couleur(nom = "Noir")
        couleurDAO.saveAll(listOf(rouge, bleu, noir))

        // ---------- TAILLES ----------
        val tailleS = Taille(nom = "S")
        val tailleM = Taille(nom = "M")
        val tailleL = Taille(nom = "L")
        tailleDAO.saveAll(listOf(tailleS, tailleM, tailleL))

        // ---------- PRODUITS ----------
        val produit1 = Produit(nom = "Haltères 5kg", description = "Haltères pour musculation", prix = 25.99).apply { categorie = catFitness }
        val produit2 = Produit(nom = "T-shirt Running", description = "T-shirt respirant pour course", prix = 19.99).apply { categorie = catVetements }
        val produit3 = Produit(nom = "Chaussures Basket", description = "Chaussures légères pour basketball", prix = 89.99).apply { categorie = catChaussures }
        val produit4 = Produit(nom = "Ballon Football", description = "Ballon officiel taille 5", prix = 29.99).apply { categorie = catCollectifs }
        val produit5 = Produit(nom = "Sac de sport", description = "Sac pratique et résistant", prix = 39.99).apply { categorie = catAccessoires }

        produitDAO.saveAll(listOf(produit1, produit2, produit3, produit4, produit5))

        // ---------- VARIATIONS ----------
        val var1 = Variation(stock = 50, prix = 25.99).apply { produit = produit1; couleur = noir; taille = tailleM }
        val var2 = Variation(stock = 30, prix = 19.99).apply { produit = produit2; couleur = bleu; taille = tailleL }
        val var3 = Variation(stock = 20, prix = 89.99).apply { produit = produit3; couleur = rouge; taille = tailleM }
        val var4 = Variation(stock = 40, prix = 29.99).apply { produit = produit4; couleur = noir }
        val var5 = Variation(stock = 15, prix = 39.99).apply { produit = produit5; couleur = bleu }

        variationDAO.saveAll(listOf(var1, var2, var3, var4, var5))

        // ---------- IMAGES ----------
        val img1 = Image(url = "https://example.com/images/halteres.jpg", altText = "Haltères 5kg", ordre = 1).apply { produit = produit1 }
        val img2 = Image(url = "https://example.com/images/tshirt-running.jpg", altText = "T-shirt Running", ordre = 1).apply { produit = produit2 }
        val img3 = Image(url = "https://example.com/images/chaussures-basket.jpg", altText = "Chaussures Basket", ordre = 1).apply { produit = produit3 }
        val img4 = Image(url = "https://example.com/images/ballon-football.jpg", altText = "Ballon Football", ordre = 1).apply { produit = produit4 }
        val img5 = Image(url = "https://example.com/images/sac-sport.jpg", altText = "Sac de sport", ordre = 1).apply { produit = produit5 }

        imageDAO.saveAll(listOf(img1, img2, img3, img4, img5))

        // ---------- AVIS ----------
        val avis1 = Avis(note = 5, commentaire = "Super haltères !").apply { utilisateur = client; produit = produit1 }
        val avis2 = Avis(note = 4, commentaire = "T-shirt très confortable").apply { utilisateur = client; produit = produit2 }
        avisDAO.saveAll(listOf(avis1, avis2))

        // ---------- PANIER ----------
        val panier = Panier(total = var1.prix).apply { utilisateur = client }
        panierDAO.save(panier)

        // ---------- COMMANDE + PAIEMENT ----------
        val paiement = Paiement(montant = var1.prix, date = LocalDateTime.now(), methode = "CB", statut = "PAID")
        paiementDAO.save(paiement)

        val commande = Commande(total = var1.prix).apply { utilisateur = client; this.panier = panier; this.paiement = paiement }
        commandeDAO.save(commande)

        println("✅ Données initiales boutique sport insérées.")
    }
}
