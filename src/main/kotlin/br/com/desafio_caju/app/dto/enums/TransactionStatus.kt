package br.com.desafio_caju.app.dto.enums

enum class TransactionStatus(val code: String) {
    APPROVED("00"),
    REPROVED("05"),
    PROBLEM("07");
}