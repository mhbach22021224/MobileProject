package com.example.application

data class WordResult(
    val word: String,
    val phonetics: String,
    val meanings: List<Meaning>,
    val sourceUrls: List<String>,
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>,
    val synonyms: List<String>,
    val antonyms: List<String>,
)

data class Definition(
    val definition: String,
    val synonyms: List<Any?>,
    val antonyms: List<Any?>,
    val example: String?,
)

data class License2(
    val name: String,
    val url: String,
)
