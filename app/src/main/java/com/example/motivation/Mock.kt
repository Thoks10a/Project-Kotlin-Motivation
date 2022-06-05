package com.example.motivation

import kotlin.random.Random


data class Phrase(val description:String, val categoryId: Int, val lang: String)


class Mock {

    private val all = MotivationConstants.filter.all
    private val face = MotivationConstants.filter.face
    private val sunny = MotivationConstants.filter.sunny
    private val langPt = MotivationConstants.language.pt
    private val langEn = MotivationConstants.language.english
    private val langFr = MotivationConstants.language.french

    val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", face, langPt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            face,
            langPt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", face, langPt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            face,
            langPt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", face, langPt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            face,
            langPt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, langPt),
        Phrase("Se você acredita, faz toda a diferença.", sunny, langPt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            sunny,
            langPt
        ),
        Phrase("Not knowing it was impossible, he went there and did it.", face, langEn),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            face,
            langEn
        ),
        Phrase("When it's darker, we see more stars!", face, langEn),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            face,
            langEn
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", face, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", face, langEn),
        Phrase("The best way to predict the future is to invent it.", sunny, langEn),
        Phrase("You lose every chance you don't take.", sunny, langEn),
        Phrase("Failure is the spice that flavors success.", sunny, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", sunny, langEn),
        Phrase("If you don't know where you want to go, any way will do.", sunny, langEn),
        Phrase("If you believe, it makes all the difference.", sunny, langEn),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            sunny,
            langEn
        ),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", face, langFr),
        Phrase(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            face,
            langFr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", face, langFr),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            face,
            langFr
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", face, langFr),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            face,
            langFr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", sunny, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", sunny, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", sunny, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", sunny, langFr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            sunny,
            langFr
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", sunny, langFr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            sunny,
            langFr
        )
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int, lang: String): String {

        // Caso a língua do usuário não esteja entre as disponíveis
        var langFilter = lang.lowercase()
        if (lang !in listOf(langEn, langPt, langFr)) {
            langFilter = langPt
        }

        val filtered = mListPhrase.filter {
            (it.categoryId == value || value == all) && (it.lang == langFilter)
        }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }
}