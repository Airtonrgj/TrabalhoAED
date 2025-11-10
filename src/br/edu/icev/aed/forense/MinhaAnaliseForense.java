package br.edu.icev.aed.forense;

import java.io.*;
import java.util.*;

public class MinhaAnaliseForense implements AnaliseForenseAvancada {

    public MinhaAnaliseForense(){

    }

/*
Implemente construtor público padrão: public MinhaClasse() {}
Use apenas bibliotecas padrão do Java + API fornecida
Trate exceções de IO adequadamente
Retorne tipos exatos especificados na interface
*/

    @Override
    public Set<String> encontrarSessoesInvalidas(String arquivo) throws IOException {
        // Implementar usando Map<String, Stack<String>>
        // A tarefa do desafio é Encontrar Sessões Inválidas, portando a implementação pensada foi a de
        // Uma pilha de login e uma de logaut usando map que server como um gerneciador de diretórios, ou seja o loguin do joão não interfere em nada o da Maria por exemplo

        //Cria uma pilha para cada usuário basicamente
        Map<String, Stack<String>> sessoesDeUsuario = new HashMap<>();

        //vai coletar todos os IDs de sessões invalidas, sem nenhuma ordem especifica, por que isso vai ser implemntado no desafio 2
        Set<String> sessoesInvalidas = new HashSet<>();


    }

    @Override
    public List<String> reconstruirLinhaTempo(String arquivo, String sessionId) throws IOException {
        // Implementar usando Queue<String>
    }

    @Override
    public List<Alerta> priorizarAlertas(String arquivo, int n) throws IOException {
        // Implementar usando PriorityQueue<Alerta>
    }

    @Override
    public Map<Long, Long> encontrarPicosTransferencia(String arquivo) throws IOException {
        // Implementar usando Stack (Next Greater Element)
    }

    @Override
    public Optional<List<String>> rastrearContaminacao(String arquivo, String origem, String destino) throws IOException {
        // Implementar usando BFS em grafo

    }
}

