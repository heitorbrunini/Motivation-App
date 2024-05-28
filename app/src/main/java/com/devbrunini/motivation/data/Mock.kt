package com.devbrunini.motivation.data

import com.devbrunini.motivation.utils.MotivationConstants
import kotlin.random.Random

class Phrase (val description: String, val categoryId: Int)
class Mock {

    private val SUN = MotivationConstants.FILTER.SUN
    private val BUBBLE = MotivationConstants.FILTER.BUBBLE
    private val INFINITY = MotivationConstants.FILTER.INFINITY


    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", BUBBLE),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", BUBBLE),
        Phrase("Quando está mais escuro, vemos mais estrelas!", BUBBLE),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", BUBBLE),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", BUBBLE),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", BUBBLE),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUN),
        Phrase("Você perde todas as chances que você não aproveita.", SUN),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUN),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUN),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUN),
        Phrase("Se você acredita, faz toda a diferença.", SUN),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUN)
    )

    fun getPhrase(category: Int): String {



        val listFiltered = if (category!=INFINITY) listPhrases.filter { it.categoryId == category } else listPhrases
        val index = Random.nextInt(0,listFiltered.size-1)
        return listFiltered[index].description
    }

}