package br.com.aprendizagem.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aprendizagem.api.service.UnidadeCurricularService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/unidadeCurricular")
public class UnidadeCurricularController {
    
    @Autowired
    private UnidadeCurricularService unidadeCurricularService;

}
