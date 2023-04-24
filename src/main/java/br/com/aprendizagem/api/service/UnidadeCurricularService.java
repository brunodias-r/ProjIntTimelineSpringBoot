package br.com.aprendizagem.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.Modulo;
import br.com.aprendizagem.api.entity.UnidadeCurricular;
import br.com.aprendizagem.api.repository.UnidadeCurricularRepository;
import br.com.aprendizagem.api.response.UnidadeCurricularResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UnidadeCurricularService {

    private UnidadeCurricularRepository unidadeCurricularRepository;

    private static Map<Long, UnidadeCurricular> listaUnidadesCurriculares = new HashMap<>();

    @Transactional
    public ResponseEntity<UnidadeCurricular> listarUnidadeCurricularPorModulo(Modulo modulo) {
        UnidadeCurricular unidadeCurricular = listaUnidadesCurriculares.get(modulo);
        if (unidadeCurricular == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(unidadeCurricular);
    }
    
    @Transactional
	public ResponseEntity<List<UnidadeCurricularResponse>> listarUnidadesCurriculares() {
		List<UnidadeCurricular> unidadesCurriculares = unidadeCurricularRepository.findAll();
		if (unidadesCurriculares.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(UnidadeCurricularResponse.of(unidadesCurriculares));
		//return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
    
}
