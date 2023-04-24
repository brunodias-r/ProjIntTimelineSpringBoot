package br.com.aprendizagem.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.Modulo;
import br.com.aprendizagem.api.entity.UnidadeCurricular;
import br.com.aprendizagem.api.repository.ModuloRepository;
import br.com.aprendizagem.api.repository.UnidadeCurricularRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UnidadeCurricularService {

    @Autowired
    private ModuloRepository moduloRepository;

    @Autowired
    private UnidadeCurricularRepository unidadeCurricularRepository;

    private static Map<Long, UnidadeCurricular> listaUnidadesCurriculares = new HashMap<>();

    public ResponseEntity<UnidadeCurricular> listarUnidadesCurricularesPorModulo(Modulo modulo) {
        UnidadeCurricular unidadeCurricular = listaUnidadesCurriculares.get(modulo);
        if (unidadeCurricular == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(unidadeCurricular);
    }

    

    // @Transactional
    // public ResponseEntity<EstudanteResponse> buscarEstudadePorId(Long id) {
    // Optional<Estudante> estudanteOpt = estudanteRepository.findById(id);
    // if (!estudanteOpt.isPresent()) {
    // return ResponseEntity.notFound().build();
    // }
    //
    // Hibernate.initialize(estudanteOpt.get().getLivros());
    // return ResponseEntity.ok(EstudanteResponse.of(estudanteOpt.get()));
    // }
}
