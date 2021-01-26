package com.sistemabancario.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    @Test
    void testSetNumeroValido() {
        final Conta instance = new Conta();
        final String esperado = "12345-6";
        instance.setNumero(esperado);
        final String obtido = instance.getNumero();
        assertEquals(esperado, obtido);
    }

    @Test
    void testSetNumeroInvalidoNaoArmazena() {
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
        final String obtido = instance.getNumero();
        assertNotEquals(invalido, obtido);
    }

    @Test
    void testInstanciaPadraoPoupanca() {
        final Conta instance = new Conta();
        assertFalse(instance.isPoupanca());
    }

    @Test
    void testSetLimiteContaEspecial() {
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double esperado = 1000;
        instance.setLimite(esperado);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }

    @Test
    void testSetLimiteContaNaoEspecial() {
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));

    }

    @Test
    void testHistoricoNotNull() {
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());

    }

    @Test
    void testGetSaldoTotal() {
        final double limite = 500;
        final double esperado = limite;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido);

    }

    @Test
    void testDepositoDinheiro() {
        final double limite = 500, deposito = 500, esperado = 1000;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);

        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido, 0.001);
    }

    @Test
    void testTipoMovimentacao() {
        final Conta conta = new Conta();
        final char esperado = 'C';
        final Movimentacao movimentacao = new Movimentacao(conta);
        movimentacao.setTipo('C');
        final char obtido = movimentacao.getTipo();
        assertEquals(esperado, obtido);
    }

    @Test
    void testMovimentacaoConfirmada() {
        final Conta conta = new Conta();
        final Movimentacao movimentacao = new Movimentacao(conta);
        movimentacao.setConfirmada(true);
        final boolean obtido = movimentacao.isConfirmada();
        assertTrue(obtido);
    }

    @Test
    void testValorAtribuido() {
        final Conta conta = new Conta();
        final Movimentacao movimentacao = new Movimentacao(conta);
        final double esperado = 500;
        movimentacao.setValor(500);
        final double obtido = movimentacao.getValor();
        assertEquals(esperado, obtido);
    }

    @Test
    void testMovimentacaoAdiciona() {
        final Conta conta = new Conta();
        Movimentacao movimentacao = new Movimentacao(conta);
        movimentacao.setId(1);
        final long esperado = 1;
        conta.addMovimentacao(movimentacao);
        final long obtido = movimentacao.getId();
        assertEquals(esperado, obtido);

    }

}
