package br.edu.icev.aed.forense;




import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

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

        //vai coletar todos os IDs de sessões invalidas, sem nenhuma ordem especifica, por que isso vai ser implemntado no desafio 2. coletas as sessões invalidas sem duplicataaas
        Set<String> sessoesInvalidas = new HashSet<>();

        //como ele vai ler o arquivo CSV
        try(BufferedReader arquivos = new BufferedReader(new FileReader(arquivo))){
            String linha = arquivos.readLine();   //ignora o cabeçalho

            //busca da informações linha por linha até chegar na última Linha
            while ((linha = arquivos.readLine()) != null){
                String[] campo = linha.split(",");  //divide a string por virgula

                String USER_ID = campo[1];
                String SESSION_ID = campo[2];
                String ACTION_TYPE = campo[3];

                //se o usuario não tiver uma pilha ainda então ela é criada
                if(!sessoesDeUsuario.containsKey(USER_ID)){
                    sessoesDeUsuario.put(USER_ID, new Stack<>());
                }
                //aqui ele cria a pilha se necessário
                Stack<String> sessoes = sessoesDeUsuario.get(USER_ID);

                //Aqui é o caso do tipo de ação ser igual ou não a de LOGIN. Poderia ser feita baseada no logout tbm
                if ("LOGIN".equals(ACTION_TYPE)){
                    //SE JA TIVER UM LOGIN então vai para sessões invalidas, ja que não pode ter um login seguido de outro
                    if (!sessoes.isEmpty()){
                        sessoesInvalidas.add(SESSION_ID);
                    }
                    //se não tiver então ele empilha normalmente nas sessoes
                    sessoes.push(SESSION_ID);
                } else if ("LOGOUT".equals(ACTION_TYPE)) {
                    if (sessoes.isEmpty() || !sessoes.peek().equals(SESSION_ID)){
                        sessoesInvalidas.add(SESSION_ID);
                    }else {
                        //esse logout não tem problemas então é so desempilhar 
                        sessoes.pop();
                    }

                    
                }
            }
        }
        return sessoesInvalidas;
    }

    @Override
    public List<String> reconstruirLinhaTempo(String arquivo_logs, String sessionId) throws IOException {
        // Implementar usando Queue<String>
        return null;
    }

    @Override
    public List<Alerta> priorizarAlertas(String arquivo, int n) throws IOException {
        // Implementar usando PriorityQueue<Alerta>
        Comparator<Alerta> comparador = new Comparator<Alerta>() {
            @Override
            public int compare(Alerta alerta1, Alerta alerta2) {
                //retorna em ordem decrescente ou seja, o de maior priorridade e depois o de menor prioridade
                return alerta2.getSeverityLevel() - alerta1.getSeverityLevel();
            }
        };

        PriorityQueue<Alerta> filaDePrioridadeDeAlertas = new PriorityQueue<>(comparador);
        try(BufferedReader arquivos = new BufferedReader(new FileReader(arquivo))) {
            String linha = arquivos.readLine();   //ignora o cabeçalho como nas outras

            int severityLevel = 0;
            while ((linha = arquivos.readLine()) != null) {
                String[] campo = linha.split(",");

                //extrai todos os campos para mostrar
                long timestamp = Long.parseLong(campo[0]);
                String userId = campo[1];
                String sessionId = campo[2];
                String actionType = campo[3];
                String targetResource = campo[4];
                severityLevel = Integer.parseInt(campo[5]);
                long bytesTransferred = Long.parseLong(campo[6]);

            }

        }
        return null;
    }

    @Override
    public Map<Long, Long> encontrarPicosTransferencia(String arquivo) throws IOException {
        // Implementar usando Stack (Next Greater Element)
        return null;
    }

    @Override
    public Optional<List<String>> rastrearContaminacao(String arquivo, String origem, String destino) throws IOException {
        // Implementar usando BFS em grafo
        return null;

    }
}

