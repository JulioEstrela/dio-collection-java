package map.ordenacao.agendaDeEventos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    AgendaEventos() {
        this.eventosMap = new HashMap<LocalDate, Evento>();
    }

    void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }
    void exibirAgendaOrganizadaPorData() {
        // LocalDate implementa Comparable
        Map<LocalDate, Evento> eventosOrganizadosPorData = new TreeMap<>(eventosMap);
        System.out.println(eventosOrganizadosPorData);
    }
    Evento obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Optional<Evento> proximoEvento = Optional.empty();
        for (Map.Entry<LocalDate, Evento> entry : eventosMap.entrySet()) {
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximoEvento = Optional.of(entry.getValue());
                break;
            }
        }
        return proximoEvento.orElseThrow();
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2000, 12, 10), "evento1", "atracao1");
        agendaEventos.adicionarEvento(LocalDate.of(2010, 12, 10), "evento2", "atracao2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 6, 10), "evento3", "atracao3");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 8, 10), "evento4", "atracao4");

        agendaEventos.exibirAgendaOrganizadaPorData();
        System.out.println(agendaEventos.obterProximoEvento());
    }

}
