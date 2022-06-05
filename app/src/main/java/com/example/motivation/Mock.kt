package com.example.motivation

import kotlin.random.Random


data class Phrase(val description:String, val categoryId: Int)


class Mock {

    private val all = MotivationConstants.filter.all
    private val face = MotivationConstants.filter.face
    private val sunny = MotivationConstants.filter.sunny

    val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", face),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", face),
        Phrase("Quando está mais escuro, vemos mais estrelas!", face),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", face),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", face),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", face),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int): String {
        val filtered = mListPhrase.filter { (it.categoryId == value || value == all) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }
}